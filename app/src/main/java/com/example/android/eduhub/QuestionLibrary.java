package com.example.android.eduhub;

import android.support.v7.app.AppCompatActivity;

public class QuestionLibrary extends AppCompatActivity {

    public static String mQuestionsAddmath1 [] = {
            "Differentiate y = (x^3 + 7x - 1)(5x + 2) using product rule.",
            "Differentiate y = 5^2 + sin x cos x using product rule.",
            "Differentiate y = x^2 sin^3 (5x) using product rule.",
            "Differentiate y = sec^2(x^4)tan^3(x^4) using product rule.",
    };

    // 2D array to store choices
    public static String mChoicesAddmath1 [][] = {
            {"y = 10x^3 + 8x^2 + 75x + 9", "y = 20x^3 + 6x^2 + 70x + 9", "y = 15x^3 + 4x^2 + 78x + 3"},
            {"y = 12x + cos(9x)", "y = 10x + cos(x)", "y = 10x + cos(2x)"},
            {"y = x sin^2(5x){15x cos(5x) + 2 sin(5x)}", "y = x sin^2(8x){21x cos(5x) + 12 sin(5x)}", "y = x sin^2(4x){12x cos(5x) + 2 sin(2x)}"},
            {"y = 2x^3 sec^2(x^4) tan^2(x^4){13sec^2(x^4) + 6 tan^2(x^4)}", "y = 8x^3 sec^2(x^4) tan^2(x^4){7sec^2(x^4) + 5 tan^2(x^4)}", "y = 4x^3 sec^2(x^4) tan^2(x^4){3sec^2(x^4) + 2 tan^2(x^4)}"}
    };

    // normal array to store answers
    public static String mCorrectAnswersAddmath1[] = {"y = 20x^3 + 6x^2 + 70x + 9", "y = 10x + cos(2x)", "y = x sin^2(5x){15x cos(5x) + 2 sin(5x)}", "y = 4x^3 sec^2(x^4) tan^2(x^4){3sec^2(x^4) + 2 tan^2(x^4)}"};

    public static String mQuestionsAddmath2 [] = {
            "Differentiate y = sin(5x) using chain rule.",
            "Assume that h(x) = f( g(x) ) , where both f and g are differentiable functions. If g(-1)=2, g'(-1)=3, and f'(2)=-4 , what is the value of h'(-1). Use chain rule to solve.?",
            "Differentiate y = cos^2(x^3) using chain rule.",
            "Differentiate y = (3x + 1)^2 using chain rule.",
    };
    // 2D array to store choices
    public static String mChoicesAddmath2 [][] = {
            {"5 cos(5x)", "10 cos(2x)", "5 cos(6x)"},
            {"12", "-12", "-9"},
            {"y = -4x^2 cos(x^3) sin(x^3)", "y = -9x^2 cos(x^3) sin(x^3)", "y = -6x^2 cos(x^3) sin(x^3)"},
            {"y = 2(7x + 1)", "y = 6(3x + 1)", "y = 8(9x + 1)"}
    };

    // normal array to store answers
    public static String mCorrectAnswersAddmath2[] = {"5 cos(5x)", "-12", "y = -6x^2 cos(x^3) sin(x^3)", "y = 6(3x + 1)"};

    public static String mQuestionsBio1 [] = {
            "What is the function of bronchus?",
            "Mouth consists of _______________?",
            "Pulmonary arteries carries the air ___________ from heart to lungs, whereas pulmonary veins allows the air to be carried __________ to heart.",
            "What would the color looks like when the blood vessels consist of deoxygenated blood?.",
            "What is the function of ventilation?"
    };

    // 2D array to store choices
    public static String mChoicesBio1 [][] = {
            {"Allow us to speak", "Allow air to split off and spread into different paths", "Break down sugars and release carbon dioxide"},
            {"Oral cavity", "Larynx", "Alveoli"},
            {"back, away", "away, away", "away, back"},
            {"Red", "Dark and purplish", "Orange"},
            {"Get oxygen in and release carbon dioxide", "Connect to blood flow", "Split bronchus into smaller tubes"}
    };

    // normal array to store answers
    public static String mCorrectAnswersBio1[] = {"Allow air to split off and spread into different paths", "Oral cavity", "away, back", "Dark and purplish", "Get oxygen in and release carbon dioxide"};

    public static String mQuestionsBio2 [] = {
            "The concentration of _________ in deoxygenated blood is higher than the concentration of carbon dioxide in _________.",
            "Where does the oxygen diffuses across?",
            "________ is a small proteins that consists of 4 heme groups where each of them can bond to oxygen molecules.",
            "In _________ contain millions of hemoglobin proteins.",
            "__________ is a general fluid of blood which does not include red blood cells.",
            "All cells need a _________ to generate the protein that build up in order to exist and structural make itself the way it needs to be made."
    };

    // 2D array to store choices
    public static String mChoicesBio2 [][] = {
            {"carbon dioxide, alveolus", "nitrogen, artery", "oxygen, membrane"},
            {"Artery", "Nucleus", "Membrane"},
            {"Hemoglobin", "Ventilation", "Larynx"},
            {"White blood cells", "nucleus", "Red blood cells"},
            {"Pulmonary capillaries", "Plasma", "Bronchus"},
            {"nucleus and DNA", "pulmonary arteries and blood vessels", "pharynx and cellular"}
    };

    // normal array to store answers
    public static String mCorrectAnswersBio2[] = {"carbon dioxide, alveolus", "Membrane", "Hemoglobin", "Red blood cells", "Plasma", "nucleus and DNA"};

    public static String mQuestionsChem1 [] = {
            "_________ is a type of matter composed of atoms of two or more elements chemically combined in fixed proportions.",
            "_________ are very light, negatively charged particles that exist in the region around the atom's positively charged nucleus.",
            "A _________ is the nuclear particle having a positive charge equal to that of the electron's and a mass more than 1800 times that of the electron.",
            "A _________ is an atom characterized by a definite atomic number and mass number.",
    };

    // 2D array to store choices
    public static String mChoicesChem1 [][] = {
            {"Compound", "Sodium", "Neutrons"},
            {"Protons", "Nucleus", "Electrons"},
            {"electron", "proton", "neutron"},
            {"hydrogen", "isotopes", "nuclide"}
    };

    // normal array to store answers
    public static String mCorrectAnswersChem1[] = {"Compound", "Electrons", "proton", "nuclide"};

    public static String mQuestionsChem2 [] = {
            "The mass of an electron is _________ whereas the mass of a proton is _________.",
            "The standard unit of atomic mass has been one-twelfth the mass of an atom of the isotope _________",
            "The observed atomic mass is slightly less than the sum of the masses of the _________, __________ and _________ that make up the atom.",
            "An atom's atomic mass is closed to its _________, but will have some deviation in the decimal place.",
    };

    // 2D array to store choices
    public static String mChoicesChem2 [][] = {
            {"10.136 x 10^-30, 2.172 x 10^-27", "9.107 x 10^-31, 1.672 x 10^-27", "9.111 x 10^-33, 1.672 x 10^-28"},
            {"carbon-16", "carbon-10", "carbon-12"},
            {"atom, carbon and hydrogen", "protons, neutrons and electrons", "oxygen, protons and neutrons"},
            {"length number", "mass number", "weight number"}
    };

    // normal array to store answers
    public static String mCorrectAnswersChem2[] = {"9.107 x 10^-31, 1.672 x 10^-27", "carbon-12", "protons, neutrons and electrons", "mass number"};

    public static String mQuestionsMaths1 [] = {
            "If A = {1, 3, 5, 7, 9} and B = {2, 3, 5, 7}, what is A ∪ B?",
            "If A = {1, 3, 5, 7, 9} and B = {2, 3, 5, 7}, what is A ∩ B?",
            "If A is the set of factors of 15, B is the set of prime numbers less than 10, C is the set of even numbers less than 9, then what is (A ∪ B) ∩ C?",
            "If A, B, and C are any three sets, then which of the following is equal to B - (A ∪ C)?",
    };

    // 2D array to store choices
    public static String mChoicesMaths1 [][] = {
            {"A U B = {1, 2, 3, 9}", "A U B = {1, 3, 9}", "A U B = {1, 2, 3, 5, 7, 9}"},
            {"A ∩ B = {1, 3, 5, 7}", "A ∩ B = {3, 5, 7}", "A ∩ B = {1, 3, 5, 7, 9}"},
            {"(A ∪ B) ∩ C = {2, 9, 15}", "(A ∪ B) ∩ C = {2, 15}", "(A ∪ B) ∩ C = {2}"},
            {"B - (A ∪ C) = (B - A) ∩ (B - C)", "B - (A ∪ C) = (B - A) ∩ (A - C)", "B - (A ∪ C) = (A - B) ∩ (A - C)"}
    };

    // normal array to store answers
    public static String mCorrectAnswersMaths1[] = {"A U B = {1, 2, 3, 5, 7, 9}", "A ∩ B = {3, 5, 7}", "(A ∪ B) ∩ C = {2}", "B - (A ∪ C) = (B - A) ∩ (B - C)"};

    public static String mQuestionsMaths2 [] = {
            "Solve Equation: x + 1 = 9",
            "Solve Equuation: x + 9 = 18 - 2x",
            "Solve Equation: -x - 1 = 221 + 2x",
            "Solve Equation: -10x - 19 = 19 - 8x",
    };

    // 2D array to store choices
    public static String mChoicesMaths2 [][] = {
            {"x = 7", "x = 8", "x = 10"},
            {"x = 5", "x = 3", "x = 2"},
            {"x = -79", "x = -70", "x = -74"},
            {"x = -19", "x = -20", "x = -10"}
    };

    // normal array to store answers
    public static String mCorrectAnswersMaths2[] = {"x = 8", "x = 3", "x = -74", "x = -19"};

    public static String mQuestionsPhy1 [] = {
            "What is the average velocity of a car that moved 60km in 3 hours?",
            "What is the average velocity of a car that moved 40 km East and 80 km West in 2 hours?",
            "John drove for 3 hours at a rate of 50 miles/hour and for 2 hours at 60 miles per hour. What was his average speed for the whole journey?",
            "A car travels between 2 towns 60 miles apart in 2 hours. What is its average speed?",
    };

    // 2D array to store choices
    public static String mChoicesPhy1 [][] = {
            {"20 km/h", "35.9 km/h", "42 km/h"},
            {"35.9 km/h", "20 km/h", "42 km/h"},
            {"45 miles/hour", "54 miles/hour", "62 miles/hour"},
            {"30 miles/hour", "10 miles/hour", "30.5 miles/hour"}
    };

    // normal array to store answers
    public static String mCorrectAnswersPhy1[] = {"20 km/h", "20 km/h", "54 miles/hour", "30 miles/hour"};

    public static String mQuestionsPhy2 [] = {
            "A feather is dropped from a height of 1.40 meters. The acceleration is 1.67 m/s2. Determine the time for the feather to fall.",
            "Deck of tall skyscraper 370 m above the street. Determine the time required for a penny to free fall from the deck to the street below.",
            "A plane has a takeoff speed of 88.3 m/s and requires 1365 m to reach that speed. Determine the time required to reach this speed.",
            "A car cruises at an average speed of 50 miles per hour.",
            "How much time will it take to go 600 miles?",
    };

    // 2D array to store choices
    public static String mChoicesPhy2 [][] = {
            {"t = 0.12 s", "t = 2.19 s", "t = 1.29 s"},
            {"t = 8.69 s", "t = 10.69 s", "t = 7.69 s"},
            {"t = 31.8 s", "t = 30.8 s", "t = 29.26 s"},
            {"t = 12 hours", "t = 10 hours", "t = 12.5 hours"}
    };

    // normal array to store answers
    public static String mCorrectAnswersPhy2[] = {"t = 1.29 s", "t = 8.69 s", "t = 30.8 s", "t = 12 hours"};

    // getQuestion > return question from mQuestion
    public String getQuestion(int a, String[] b){
        String question = b[a];
        return question;
    }

    // returning the 1st item in an array of the mChoices
    public String getChoice1(int a, String[][] b){
        String choice0 = b[a][0];
        return choice0;
    }

    // returning the 2nd item in an array of the mChoices
    public String getChoice2(int a, String[][] b) {
        String choice1 = b[a][1];
        return choice1;
    }

    // returning the 3rd item in an array of the mChoices
    public String getChoice3(int a, String[][] b){
        String choice2 = b[a][2];
        return choice2;
    }

    // returns correct answer
    public String getCorrectAnswer(int a, String[] b){
        String answer = b[a];
        return answer;
    }
}