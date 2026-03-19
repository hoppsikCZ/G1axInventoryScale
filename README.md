# G1ax Inventory Scale

A Minecraft Fabric mod that lets you customize the size of your inventory and container screens independently from your GUI scale.

## Features

- **Container Scaling**: Adjust the size of inventory screens, chests, and other containers (0.5x to 8x)
- **Tooltip Scaling**: Separately control tooltip size (0.5x to 2x)
- **Easy Configuration**: In-game config screen via Mod Menu
- **Compatibility**: Works with popular mods like Blur and Controlify

## Requirements

- **Minecraft**: 1.21.11
- **Fabric Loader**: 0.18.4 or higher
- **Java**: 21 or higher
- **Dependencies**:
  - Fabric API
  - YACL (Yet Another Config Lib)
  - Mod Menu (optional, for config screen)

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/)
2. Download [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download [YACL](https://modrinth.com/mod/yacl)
4. Download this mod from [Releases](https://github.com/AkaTriggered/G1axInventoryScale/releases)
5. Place all downloaded `.jar` files in your `.minecraft/mods` folder
6. Launch Minecraft with the Fabric profile

## Usage

### Opening the Config

1. Install [Mod Menu](https://modrinth.com/mod/modmenu) (optional but recommended)
2. Click "Mods" from the main menu
3. Find "G1ax Inventory Scale" and click the config button

### Configuration Options

- **Container Scale**: Changes the size of inventory and container screens
  - Range: 0.5x to 8x
  - Default: 1.0x
  - Note: Very large values may make containers bigger than your screen

- **Tooltip Scale**: Changes the size of item tooltips
  - Range: 0.5x to 2x
  - Default: 1.0x

### Config File

Settings are saved to `.minecraft/config/g1axinventoryscale.json`

```json
{
  "containerSize": 1.0,
  "tooltipSize": 1.0
}
```

## Compatibility

This mod includes compatibility patches for:

- **Blur** (5.0.0+): Ensures background blur effects scale correctly
- **Controlify** (2.2.1+): Fixes virtual mouse positioning with scaled containers

## Building from Source

```bash
git clone https://github.com/AkaTriggered/G1axInventoryScale.git
cd G1axInventoryScale
./gradlew build
```

The compiled mod will be in `build/libs/`

## Contributing

Contributions are welcome! Here's how you can help:

### Reporting Issues

1. Check if the issue already exists in [Issues](https://github.com/AkaTriggered/G1axInventoryScale/issues)
2. Create a new issue with:
   - Minecraft version
   - Mod version
   - Steps to reproduce
   - Screenshots/videos if applicable
   - Crash logs (if applicable)

### Pull Requests

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature`)
3. Make your changes
4. Test thoroughly
5. Commit your changes (`git commit -m 'Add some feature'`)
6. Push to the branch (`git push origin feature/your-feature`)
7. Open a Pull Request

#### PR Guidelines

- Follow existing code style
- Test with the latest Minecraft version
- Update documentation if needed
- Keep changes focused and atomic
- Describe what your PR does and why

## Technical Details

### How It Works

The mod uses Mixin to inject into Minecraft's rendering pipeline:

- **GameRendererMixin**: Scales the entire screen rendering
- **GuiGraphicsMixin**: Handles tooltip positioning and scaling
- **MouseHandlerMixin**: Adjusts mouse coordinates for scaled screens
- **ScreenMixin**: Modifies screen dimensions for proper layout

### Dependencies Included

- MixinExtras: Advanced mixin features
- MixinConstraints: Conditional mixin loading for compatibility

## License

This project is licensed under CC0 1.0 Universal - see the [LICENSE](LICENSE) file for details.

## Credits

- **Author**: AkaTriggered/G1ax
- **Built with**: Fabric, YACL, MixinExtras

## Links

- [GitHub Repository](https://github.com/AkaTriggered/G1axInventoryScale)
- [Issue Tracker](https://github.com/AkaTriggered/G1axInventoryScale/issues)
- [Modrinth](https://modrinth.com/mod/g1axinventoryscale) (if published)

## Support

If you encounter any issues or have questions:

1. Check the [FAQ](#faq) below
2. Search [existing issues](https://github.com/AkaTriggered/G1axInventoryScale/issues)
3. Create a new issue with details

## FAQ

**Q: The mod isn't working!**  
A: Make sure you have Fabric API and YACL installed.

**Q: My screen is too big/small!**  
A: Open the config and adjust the Container Scale slider.

**Q: Does this work with other mods?**  
A: Yes! It includes compatibility for Blur and Controlify, and should work with most other mods.

**Q: Can I use this in my modpack?**  
A: Yes! This mod is CC0 licensed, so you're free to use it however you want.

**Q: Does this work on servers?**  
A: This is a client-side only mod. It works on any server without needing to be installed server-side.
