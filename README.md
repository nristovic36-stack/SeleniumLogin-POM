# Selenium Login - Page Object Model (POM)

Projekat za automatizaciju testiranja login funkcionalnosti korišćenjem **Java**, **Selenium WebDriver**, **TestNG** i **Maven** alata, implementiran po **Page Object Model (POM)** dizajn paternu.

## Korišćene tehnologije
* **Java 21**
* **Selenium WebDriver** (`4.52.0`)
* **TestNG** (`7.12.0`)
* **Maven** (upravljanje zavisnostima i pokretanje testova)

## Struktura projekta
* `src/test/java` – Page klase (lokatori i metode za interakciju sa elementima) i Test klase
* `pom.xml` – Maven konfiguracioni fajl sa svim potrebnim bibliotekama

## Pokretanje testova
1. Klonirajte repozitorijum na vaš računar:
   ```bash
   git clone https://github.com
   ```
2. Uđite u folder projekta:
   ```bash
   cd SeleniumLogin-POM
   ```
3. Pokrenite testove putem Maven-a:
   ```bash
   mvn clean test
   ```
