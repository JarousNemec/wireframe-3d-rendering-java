# Wireframe 3D rendering app

Projekt do PGRF1 - transformace a zobrazení drátového modelu 3D scény.
- Začínáme v Model space 
- vynásobené modelovací maticí to přeneseme do World space


## Co je potřeba

- **JDK 21** nebo novější (vyvíjeno na JDK 23)
- knihovny jsou přímo v projektu ve složce `lib/`, takže není potřeba Maven ani internet:
  - JUnit 5 (`junit-*`, `opentest4j`, `apiguardian`) - jen pro testy

## Spuštění v IntelliJ IDEA

1. Otevřít složku projektu (File > Open). Modul je popsaný v `wireframe-3d-rendering-java.iml`, ten už na knihovny v `lib/` odkazuje.
2. Nastavit SDK na JDK 21 nebo novější (File > Project Structure > Project).
3. Spustit `src/Main.java`.

Testy: pravým na složku `test` > Run 'All Tests'.

## Spuštění z příkazové řádky (Windows)

Spouštět ze složky projektu:

```
javac -d out -sourcepath src src/Main.java
java -cp out Main
```

`-sourcepath` zařídí, že se přeloží všechno, co `Main` používá.

## Struktura

- `src/` - zdrojáky
  - `src/transforms/` - převzatá knihovna (matice, vektory, kamera, kubiky) z https://gitlab.com/honza.vanek/transforms
- `test/` - unit testy
- `lib/` - knihovny (JUnit)
- `doc/` - autoevaluační tabulka
