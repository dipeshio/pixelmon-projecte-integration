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

| Tier | Category | Example Items | EMC Value |
|------|----------|---------------|-----------|
| Common | Apricorns | Red, Blue, etc. | 64 |
| Common | Cooked Apricorns | Cooked Red, etc. | 256 |
| Uncommon | Poké Balls | Poké, Great, Ultra | 2k - 8k |
| Rare | Evolution Stones | Fire, Water, Thunder | 16k |
| Rare | Vitamins | Rare Candy, Protein | 32k |
| Very Rare | Evolution Items | King's Rock, Metal Coat | 64k |
| Very Rare | Fossils | Helix, Dome, Old Amber | 64k |
| Ultra Rare | Mega Stones | All types | 128k |
| Ultra Rare | Z-Crystals | Type / Pokemon-specific | 64k - 128k |
| Ultra Rare | Special Balls | Beast, Dream, Safari | 128k - 256k |
| Legendary | Ability Patch | - | 512k |
| Legendary | Master Ball | - | 512k |
| Legendary | GS Ball | - | 1M |
| Legendary | Legend Plate | - | 1M |

## License

MIT License - See [LICENSE](LICENSE) for details.

## Contributing

Issues and pull requests are welcome! Please ensure your contributions align with the mod's goals of providing balanced EMC values for Pixelmon items.
