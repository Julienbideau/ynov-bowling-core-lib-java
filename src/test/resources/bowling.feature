Feature: Calcul de score de bowling

  Scenario: Calcul de score unitaire
    Given J'ai fait ce score lors de mon lancer : premier lancer : 8, second lancer : 2
    When Je calcule mon score
    Then J'ai un score de 10 points

  Scenario: Calcul d'une partie entière
    Given J'ai fait ces lancers
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 0  | 0  |
      | 10 | 10 | 10 |
    When Je calcule mon score
    Then J'ai un score de 300 points

  Scenario: Calcul d'une partie entière du coding test
    Given J'ai fait ces lancers
      | 10 | 0 | 0 |
      | 10 | 0 | 0 |
      | 7  | 3 | 0 |
      | 10 | 0 | 0 |
      | 10 | 0 | 0 |
      | 9  | 1 | 0 |
      | 9  | 1 | 0 |
      | 6  | 3 | 0 |
      | 10 | 0 | 0 |
      | 9  | 1 | 7 |
    When Je calcule mon score
    Then J'ai un score de 197 points
    
    