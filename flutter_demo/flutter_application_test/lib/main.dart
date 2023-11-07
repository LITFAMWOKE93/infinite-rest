import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

// MyApp is a top-level widget that requires a build method
// It notifies flutter what the widget is composed of
// similar to the entity component relationship of some game engines.

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (context) => MyAppState(),
      child: MaterialApp(
        // Title allows the decice OS to identify and display the apps name
        title: 'TDEE App',
        theme: ThemeData(
          useMaterial3: true,
          colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepOrange),
        ),
        home: MyHomePage(),
      ),
    );
  }
}

enum Gender { male, female }

enum ActivityLevel { sedentary, light, moderate, very, elite }

class UserData {
  int age = 0;
  Gender gender = Gender.male;
  double weight = 60;
  double height = 160;
  ActivityLevel activityLevel = ActivityLevel.sedentary;
}

//MyAppState uses ChangeNotifier as a events/actions manager
class MyAppState extends ChangeNotifier {
  UserData _userData = UserData();

  void setUserData(UserData data) {
    _userData = data;
  }

  UserData getUserData() {
    return _userData;
  }

  // Check the gender of the user input, and perform the appropriate TDEE formula.
  double calculateTDEE() {
    UserData user = getUserData();

    if (user.gender == Gender.male) {
      double BMR = 88.362 +
          (13.397 * user.weight) +
          (4.799 * user.height) -
          (5.677 * user.age);
      switch (user.activityLevel) {
        case ActivityLevel.sedentary:
          {
            return BMR * 1.2;
          }
        case ActivityLevel.light:
          {
            return BMR * 1.375;
            //statements; 1.2, 1.375, 1.55, 1.725, 1.9
          }
        case ActivityLevel.moderate:
          {
            return BMR * 1.55;
          }
        case ActivityLevel.very:
          {
            return BMR * 1.725;
          }
        case ActivityLevel.elite:
          {
            return BMR * 1.9;
          }

        default:
          {
            return BMR * 1.2;
          }
      }
    } else {
      double BMR = 447.593 +
          (9.247 * user.weight) +
          (3.098 * user.height) -
          (4.330 * user.age);
      switch (user.activityLevel) {
        case ActivityLevel.sedentary:
          {
            return BMR * 1.2;
          }
        case ActivityLevel.light:
          {
            return BMR * 1.375;
            //statements; 1.2, 1.375, 1.55, 1.725, 1.9
          }
        case ActivityLevel.moderate:
          {
            return BMR * 1.55;
          }
        case ActivityLevel.very:
          {
            return BMR * 1.725;
          }
        case ActivityLevel.elite:
          {
            return BMR * 1.9;
          }

        default:
          {
            return BMR * 1.2;
          }
      }
    }
  }

  var current = WordPair.random();

// Function Definition being defined inside of the MyAppState
  void getNext() {
    current = WordPair.random();
    notifyListeners();
  }
}

class ActivityLevelDropDown extends StatefulWidget {
  @override
  _ActivityLevelDropDownState createState() => _ActivityLevelDropDownState();
}

class _ActivityLevelDropDownState extends State<ActivityLevelDropDown> {
  ActivityLevel _selectedActivityLevel = ActivityLevel.light;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: DropdownButton<ActivityLevel>(
          value: _selectedActivityLevel,
          onChanged: (ActivityLevel? newValue) {
            setState(() {
              _selectedActivityLevel = newValue as ActivityLevel;
            });
          },
          items: ActivityLevel.values.map((ActivityLevel level) {
            return DropdownMenuItem<ActivityLevel>(
              value: level,
              child: Text(level.toString().split('.').last),
            );
          }).toList(),
        ),
      ),
    );
  }
}

class GenderSelectionRadial extends StatefulWidget {
  @override
  _GenderSelectionRadialState createState() => _GenderSelectionRadialState();
}

class _GenderSelectionRadialState extends State<GenderSelectionRadial> {
  Gender _selectedGender = Gender.male; // Variable to hold the selected gender

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ListTile(
          title: Text('Male'),
          leading: Radio(
            value: Gender.male,
            groupValue: _selectedGender,
            onChanged: (Gender? value) {
              setState(() {
                _selectedGender = value as Gender;
              });
            },
          ),
        ),
        ListTile(
          title: Text('Female'),
          leading: Radio(
            value: Gender.female,
            groupValue: _selectedGender,
            onChanged: (Gender? value) {
              setState(() {
                _selectedGender = value as Gender;
              });
            },
          ),
        ),
      ],
    );
  }
}

//StatelessWidget with a build method and attributes, set to watch the MyAppState
// and adjust content conditionally.
class MyHomePage extends StatelessWidget {
  final TextEditingController ageController = TextEditingController();
  final TextEditingController weightController = TextEditingController();
  final TextEditingController heightController = TextEditingController();

  // Storage variables for current app state
  ActivityLevel selectedActivityLevel = ActivityLevel.sedentary;

  @override
  Widget build(BuildContext context) {
    // the watch function performs similarly to a draw call and updates every
    // frame based on state
    var appState = context.watch<MyAppState>();

    return Scaffold(
      body: Column(
        children: [
          TextField(
            controller: ageController,
            keyboardType: TextInputType.number,
            decoration: InputDecoration(labelText: 'Age'),
          ),
          TextField(
            controller: weightController,
            keyboardType: TextInputType.number,
            decoration: InputDecoration(labelText: 'Weight (kg)'),
          ),
          TextField(
            controller: heightController,
            keyboardType: TextInputType.number,
            decoration: InputDecoration(labelText: 'Height (cm)'),
          ),
          GenderSelectionRadial(),
          Flexible(
            child: ActivityLevelDropDown(),
          ),
          ElevatedButton(
            onPressed: () {
              // Parse user input and set data
              UserData userData = UserData();
              userData.age = int.parse(ageController.text);
              userData.weight = double.parse(weightController.text);
              userData.height = double.parse(heightController.text);
              // Set other user data properties based on dropdown/radio button selections

              appState.setUserData(userData);

              // Calculate TDEE
              double tdee = appState.calculateTDEE();

              // Display the calculated TDEE
              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(content: Text('Calculated TDEE: $tdee')),
              );
            },
            child: Text('Calculate'),
          ),
        ],
      ),
    );
  }
}
