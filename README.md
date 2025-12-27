# PixelE Bridge

A NeoForge 1.21.1 compatibility mod that integrates [Pixelmon](https://pixelmonmod.com/) with [ProjectE](https://www.curseforge.com/minecraft/mc-mods/projecte), enabling EMC (Energy-Matter Covalence) values for Pixelmon items.

## Features

- **500+ EMC Mappings**: Comprehensive coverage of Pixelmon items including:
  - All Poké Balls (40+ types including Hisuian balls)
  - Apricorns and crafting materials
  - Evolution stones and items
  - Berries, mints, and vitamins
  - Mega Stones and Z-Crystals
  - TMs, HMs, and held items
  - Fossils and valuable items
  - Machines and tools

- **Smart EMC Strategy**:
  - Base materials get explicit values (e.g., Apricorns = 64 EMC)
  - Complex items inherit EMC from recipes via ProjectE's mapper
  - Non-craftable items get direct override values

- **Dual Registration**: Both programmatic and datapack-based EMC definitions for reliability

## Requirements

- Minecraft 1.21.1
- NeoForge 21.1.172+
- Pixelmon (1.21.1 version)
- ProjectE (1.21.1 version)

## Building

### Prerequisites
- JDK 21
- Pixelmon and ProjectE mod JARs (place in `libs/` folder)

### Compile
```bash
./gradlew build
```

The compiled mod will be at `build/libs/pixele-1.0.0.jar`

## Installation

1. Install NeoForge 1.21.1
2. Install Pixelmon and ProjectE
3. Copy `pixele-1.0.0.jar` to your `mods/` folder
4. Launch the game

## EMC Value Reference

| Category | Example Items | EMC Value |
|----------|---------------|-----------|
| Apricorns | Red, Blue, etc. | 64 |
| Cooked Apricorns | Cooked Red, etc. | 128 |
| Evolution Stones | Fire, Water, Thunder | 2,048 |
| Rare Evolution Stones | Dawn, Dusk, Shiny | 4,096 |
| Rare Candy | - | 8,192 |
| Mega Stones | All types | 16,384 |
| Master Ball | - | 32,768 |
| Legend Plate | - | 65,536 |

## License

MIT License - See [LICENSE](LICENSE) for details.

## Contributing

Issues and pull requests are welcome! Please ensure your contributions align with the mod's goals of providing balanced EMC values for Pixelmon items.
