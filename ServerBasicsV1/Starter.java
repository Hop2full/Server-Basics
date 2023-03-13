public class Starter {
}package com.example.starter;


        import org.bukkit.Material;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import org.bukkit.inventory.ItemStack;
        import org.bukkit.plugin.java.JavaPlugin;
        import org.bukkit.potion.PotionEffect;
        import org.bukkit.potion.PotionEffectType;

public class StarterPlugin extends JavaPlugin {

    private int cooldownTime = 10 * 60 * 1000; // 10 minutes in milliseconds
    private CooldownManager cooldowns;

    @Override
    public void onEnable() {
        cooldowns = new CooldownManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("starter")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (cooldowns.isOnCooldown(player.getUniqueId())) {
                    player.sendMessage("You must wait " + cooldowns.getRemainingTime(player.getUniqueId()) + " seconds before using this command again.");
                    return true;
                }
                player.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
                player.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
                player.getInventory().addItem(new ItemStack(Material.IRON_AXE));
                player.getInventory().addItem(new ItemStack(Material.IRON_SHOVEL));
                player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                player.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 32));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 255));
                cooldowns.putOnCooldown(player.getUniqueId(), cooldownTime);
                player.sendMessage("You have received your starter kit!");
                return true;
            } else {
                sender.sendMessage("This command can only be used by a player.");
                return true;
            }
        }
        return false;
    }

}

