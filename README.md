<div align="center">
<img src="assets/kotlib.svg" height="128">
</div>

# ✨ KotLib ✨
Silly dependency for those paranoids that don't like having to shade ~1Mb of Kotlin libraries into their plugins. \
Could make sense if there are a lot of small plugins using kotlin in the server. \
Yes, we're those kind of paranoids.

## ❗Before using
This plugins only makes sense on versions below 1.16.5 \
Spigot 1.16.5+ allows downloading dependencies from maven central using `libraries` section in `plugin.yml` \
Paper 1.19.4+ allows downloading dependencies from any maven repository declaring a `PluginLoader` and referencing it in `paper-plugin.yml`

## ⚙️ Logic
Gradle just packages the Kotlin libraries into the jar

## 📃 Credits
[Kotlin Logo](https://plugins.jetbrains.com/plugin/14835-kotlin-builder-generator)
