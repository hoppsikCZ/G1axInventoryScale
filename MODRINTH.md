# G1ax Inventory Scale

Scale your inventory and container screens independently from your GUI scale!

## What does this mod do?

Ever wanted to make your inventory bigger or smaller without changing your entire GUI scale? This mod lets you do exactly that! You can adjust the size of chests, inventories, and other container screens separately from the rest of your game interface.

## Features

✨ **Container Scaling** - Make your inventory screens bigger or smaller (0.5x to 8x)  
✨ **Tooltip Scaling** - Adjust tooltip size separately (0.5x to 2x)  
✨ **Easy Config** - Simple in-game settings screen  
✨ **Client-Side Only** - Works on any server, no server installation needed  
✨ **Mod Compatibility** - Built-in support for Blur and Controlify

## How to Use

1. Install the mod and its dependencies
2. Open Minecraft and go to Mods → G1ax Inventory Scale → Config
3. Adjust the sliders to your preference
4. Done! Your changes apply instantly

## Configuration

**Container Scale** (0.5x - 8x)
- Controls the size of inventory screens, chests, and other containers
- Default: 1.0x (normal size)
- Warning: Very large values may make containers bigger than your screen

**Tooltip Scale** (0.5x - 2x)
- Controls the size of item tooltips
- Default: 1.0x (normal size)

Settings are automatically saved to `.minecraft/config/g1axinventoryscale.json`

## Requirements

- **Minecraft** 1.21.11
- **Fabric Loader** 0.18.4+
- **Java** 21+
- **Fabric API** (required)
- **YACL** (Yet Another Config Lib) (required)
- **Mod Menu** (optional, for config screen)

## Compatibility

This mod is designed to work with most other mods. It includes special compatibility for:

- **Blur** (5.0.0+) - Background blur effects scale correctly
- **Controlify** (2.2.1+) - Virtual mouse positioning works properly

## Installation

1. Download and install [Fabric Loader](https://fabricmc.net/use/)
2. Download [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download [YACL](https://modrinth.com/mod/yacl)
4. Download this mod
5. Put all `.jar` files in your `.minecraft/mods` folder
6. Launch Minecraft!

## FAQ

**Q: Does this work on servers?**  
A: Yes! This is a client-side mod, so it works on any server without needing to be installed server-side.

**Q: Can I use this in my modpack?**  
A: Absolutely! This mod is CC0 licensed, meaning you can use it freely in any modpack.

**Q: The mod isn't working!**  
A: Make sure you have both Fabric API and YACL installed. Both are required dependencies.

**Q: My containers are too big and go off-screen!**  
A: Lower the Container Scale value in the config. Try values between 0.5x and 2x for best results.

**Q: Does this affect performance?**  
A: No, the mod has minimal performance impact.

## Support

Found a bug or have a suggestion?

- Report issues on [GitHub](https://github.com/AkaTriggered/G1axInventoryScale/issues)
- Make sure to include your Minecraft version, mod version, and any crash logs

## License

This mod is released under CC0 1.0 Universal (Public Domain). You're free to use, modify, and distribute it however you want!

## Credits

Created by **AkaTriggered/G1ax**

Built with:
- Fabric
- YACL (Yet Another Config Lib)
- MixinExtras
- MixinConstraints
