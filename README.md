# MOTDRotator

🎯 A lightweight, open-source Spigot plugin to rotate your server's MOTD automatically — in sequence or randomly.

---

## ✨ Features

- 🔁 Rotates MOTDs on a timer (interval configurable)
- 🎲 Random or sequential rotation mode
- 🎨 Supports `&` color codes (e.g. `&a`, `&c`)
- 🛠️ `/motd reload` command to update MOTDs & interval without restarting
- 📄 Simple `config.yml`
- ✅ Clean, bloat-free, and open-source

---

## 📥 Installation

1. Download the latest [release](https://github.com/Farhan58901234/MOTDRotator/releases/tag/v1.0.0)
2. Drop the `.jar` into your server's `plugins/` folder
3. Start or reload your server
4. Edit `plugins/MOTDRotator/config.yml` to add your custom MOTDs
5. Run `/motd reload` in-game or from console

---

## ⚙️ Configuration

```yaml
motds:
  - "&aWelcome to &bFarhan's Server!"
  - "&eEnjoy your stay &6&o:)"
  - "&dJoin our Discord! &7(discord.gg/example)"

random: false   # true = random, false = in order
interval: 60    # seconds between each rotation
```

---

## 📜 Commands & Permissions

| Command        | Description                 | Permission      |
|----------------|-----------------------------|-----------------|
| `/motd reload` | Reloads MOTDs + interval    | `motd.reload`   |

---

## 🧱 Built With

- Java 8
- Spigot API `1.20.1-R0.1-SNAPSHOT`
- Maven

---

## 📂 Project Structure

```
MOTDRotator/
├── plugin.yml
├── config.yml
├── MOTDRotator.java       (Main class)
├── MOTDManager.java       (Handles motd logic)
└── Commands/
    └── MOTDCommand.java   (/motd reload)
```

---

## 🪪 License

This project is licensed under the [MIT License](LICENSE)
