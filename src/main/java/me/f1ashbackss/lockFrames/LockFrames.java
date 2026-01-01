package me.f1ashbackss.lockFrames;

import org.bukkit.plugin.java.JavaPlugin;

public final class LockFrames extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
