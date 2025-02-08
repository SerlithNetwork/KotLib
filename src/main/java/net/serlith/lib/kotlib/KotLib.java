package net.serlith.lib.kotlib;

import org.bukkit.plugin.java.JavaPlugin;

public final class KotLib extends JavaPlugin {

    @Override
    public void onLoad() {
        this.getLogger().info("Loaded Kotlin into the server classpath");
    }

}
