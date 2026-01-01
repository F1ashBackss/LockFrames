package me.f1ashbackss.lockFrames; // ДИРЕКТОРИЯ КЛАССА

// ИМПОРТЫ
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventListener implements Listener { // КЛАСС ПЛАГИНА
    @EventHandler
    public void onFrameClick(PlayerInteractEntityEvent event) { // ОБРАБОТЧИК НАЖАТИЯ ПО ЭНТИТИ
        if (!(event.getRightClicked() instanceof ItemFrame frame)) return; // ПРОВЕРКА НА РАМКУ

        Player player = event.getPlayer(); // ИГРОК

        if (player.getInventory().getItemInMainHand().getType() != Material.FLINT) return; // ПРОВЕРКА НА НАЛИЧИЕ КРЕМЕНЯ В РУКЕ

        event.setCancelled(true); // ОТКЛЮЧАЕТ ОБРАБОТКУ

        boolean isFixed = frame.isFixed();
        frame.setFixed(!isFixed); // БЛОКИРОВКА ЕСЛИ НЕ ЗАБЛОКИРОВАНО / РАЗБЛОКИРОВКА ЕСЛИ ЗАБЛОКИРОВАНО

        Sound sound = isFixed // ВЫБИРАЕМ ЗВУК
                ? Sound.BLOCK_WOODEN_TRAPDOOR_OPEN   // ЗВУК ПРИ РАЗБЛОКИРОВКЕ
                : Sound.BLOCK_WOODEN_TRAPDOOR_CLOSE; // ЗВУК ПРИ БЛОКИРОВКЕ

        player.playSound( // ЗВУК
                player.getLocation(), // ЛОКАЦИЯ ИГРОКА
                sound, // ВЫБРАННЫЙ ЗВУК
                1f, // ГРОМКОСТЬ
                1f // ТОН
        );

        player.getWorld().spawnParticle( // СПАВН ЧАСТИЦ
                Particle.CRIT, // ВИД ЧАСТИЦЫ
                frame.getLocation(), // ЛОКАЦИЯ РАМКИ
                15, // КОЛ-ВО ЧАСТИЦ
                0.20, // X
                0.20, // Y
                0.20, // Z
                0.05 // СКОРОСТЬ
        );
    }
}