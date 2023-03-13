public class Ranks package com.example.rankplugin;

        import org.bukkit.ChatColor;
        import org.bukkit.command.Command;
        import org.bukkit.command.CommandSender;
        import org.bukkit.entity.Player;
        import org.bukkit.plugin.java.JavaPlugin;

public class RankPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RankPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RankPlugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String rank = getRank(player);

            if (cmd.getName().equalsIgnoreCase("fly")) {
                if (rank.equals("Weeb")) {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.GREEN + "You can now fly!");
                } else if (rank.equals("Sensei")) {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                }
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("godmode")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("kill")) {
                if (rank.equals("Weeb") || rank.equals("Sensei")) {
                    Player target = player;
                    if (args.length > 0) {
                        target = getServer().getPlayer(args[0]);
                    }
                    if (target != null) {
                        target.setHealth(0);
                        player.sendMessage(ChatColor.GREEN + "Player killed!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Player not found!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                }
                return true;
            }

            if (cmd.getName().equalsIgnoreCase("clearinventory")) {
                if (rank.equals("Weeb") || rank.equals("Sensei") || rank.equals("Senpai") || rank.equals("Kohai")) {
                    Player target = player;
                    if (args.length > 0) {
                        target = getServer().getPlayer(args[0]);
                    }
                    if (target != null) {
                        target.getInventory().clear();
                        player.sendMessage(ChatColor.GREEN + "Player inventory cleared!");
                    } else {
                        player.sendMessage(ChatColor.RED + "Player not found!");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                }
                return true;
            }
        }
        return false;
    }

    private String getRank(Player player) {
        String rank = "Weeb";
        if (player.hasPermission("rank.sensei")) {
            rank = "Sensei";
        } else if (player.hasPermission("rank.senpai")) {
            rank = "Senpai";
        } else if (player.hasPermission("rank.kohai")) {
            rank = "Kohai";
        }
        return rank;
    }

    public ChatColor getRankColor(String rank) {
        switch (rank) {
            case "Weeb":
                return ChatColor.RED;
            case "Sensei":
                return ChatColor.YELLOW;
            case "Senpai":
                return ChatColor.LIGHT_PURPLE;
            case "Kohai":
                return ChatColor.BLUE;
            default:
                return ChatColor.WHITE;
        }
    }

}
{
}
