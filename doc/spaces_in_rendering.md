# Přechody mezi prostory v 3D počítačové grafice

| Prostor | Přechod / operace | Co se děje |
|---|---|---|
| **Model Space** | Výchozí souřadnice | Souřadnice objektu v jeho vlastním lokálním prostoru |
| **World Space** | Modelovací matice (Model Matrix – M) | Posunutí, otočení a změna měřítka objektu ve světě |
| **View Space (Camera Space)** | Pohledová matice (View Matrix – V) | Převod do souřadnicového systému kamery |
| **Clip Space** | Projekční matice (Projection Matrix – P) | Perspektivní nebo ortografická projekce |
| **NDC (Normalized Device Coordinates)** | Perspektivní dělení (dělení složkou W) | Normalizace souřadnic do rozsahu obvykle -1 až 1 |
| **Screen Space** | Viewport transformace | Převod na konkrétní pixely obrazovky |

## Celý postup

1. **Model Space → World Space**
   - Násobení modelovací maticí (Model Matrix – M).
   - Posunutí, otočení a změna měřítka objektu.
   - `P_world = M × P_model`

2. **World Space → View Space**
   - Násobení pohledovou maticí (View Matrix – V).
   - Převod souřadnic vzhledem ke kameře.
   - `P_view = V × P_world`

3. **View Space → Clip Space**
   - Násobení projekční maticí (Projection Matrix – P).
   - Perspektivní nebo ortografická projekce.
   - `P_clip = P × P_view`

4. **Clip Space → NDC**
   - Perspektivní dělení (Perspective Divide).
   - Dělení souřadnic hodnotou W.
   - `P_ndc = (x/w, y/w, z/w)`

5. **NDC → Screen Space**
   - Viewport transformace.
   - Převod normalizovaných souřadnic na pixely obrazovky.

## Celý převod matematicky

Při použití sloupcových vektorů:

`P_clip = P × V × M × P_model`

Kde:
- **M** = Model Matrix
- **V** = View Matrix
- **P** = Projection Matrix

## Co si zapamatovat na test

- **Model Matrix** = kde a jak je objekt umístěný.
- **View Matrix** = odkud a kam se dívá kamera.
- **Projection Matrix** = jak se 3D scéna promítne do 2D.
- **Perspective Divide** = dělení hodnotou W.
- **Viewport Transform** = převod na pixely obrazovky.

**Pozor:** Při použití řádkových vektorů místo sloupcových se pořadí násobení matic obrací.
