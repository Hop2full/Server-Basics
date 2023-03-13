import org.bukkit.plugin.java.JavaPlugin;

public class ServerBasicsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // TODO: Add plugin code here
    }

    @Override
    public void onDisable() {
        // TODO: Add cleanup code here
    }
}
public class ServerBasicsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tpa").setExecutor(new TeleportCommand());
        getCommand("tpahere").setExecutor(new TeleportHereCommand());
    }

    @Override
    public void onDisable() {
        // TODO: Add cleanup code here
    }

    private class TeleportCommand implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;

            if (args.length != 1) {
                player.sendMessage("Usage: /tpa <player>");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(args[0] + " is not online.");
                return true;
            }

            // TODO: Implement teleport logic

            return true;
        }
    }

    private class TeleportHereCommand implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players.");
                return true;
            }

            Player player = (Player) sender;

            if (args.length != 1) {
                player.sendMessage("Usage: /tpahere <player>");
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            if (target == null) {
                player.sendMessage(args[0] + " is not online.");
                return true;
            }


            public class ServerBasicsPlugin extends JavaPlugin {

                @Override
                public void onEnable() {
                    // Register commands
                    getCommand("tpa").setExecutor(new TeleportCommand());
                    getCommand("tpahere").setExecutor(new TeleportHereCommand());
                    getCommand("god").setExecutor(new GodCommand());
                    getCommand("feed").setExecutor(new FeedCommand());
                    getCommand("fly").setExecutor(new FlyCommand());
                }

                @Override
                public void onDisable() {
                    // TODO: Add cleanup code here
                }

                private class TeleportCommand implements CommandExecutor {
                    // Implementation same as before
                }

                private class TeleportHereCommand implements CommandExecutor {
                    // Implementation same as before
                }

                private class GodCommand implements CommandExecutor {

                    @Override
                    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage("This command can only be used by players.");
                            return true;
                        }

                        Player player = (Player) sender;

                        // Toggle godmode for player
                        player.setInvulnerable(!player.isInvulnerable());

                        // Send message to player
                        String message = player.isInvulnerable() ? "Godmode enabled." : "Godmode disabled.";
                        player.sendMessage(message);

                        return true;
                    }
                }

                private class FeedCommand implements CommandExecutor {

                    @Override
                    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage("This command can only be used by players.");
                            return true;
                        }

                        Player player = (Player) sender;

                        // Set player's food level to maximum
                        player.setFoodLevel(20);

                        // Send message to player
                        player.sendMessage("You have been fed.");

                        return true;
                    }
                }

                private class FlyCommand implements CommandExecutor {

                    @Override
                    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
                        if (!(sender instanceof Player)) {
                            sender.sendMessage("This command can only be used by players.");
                            return true;
                        }

                        Player player = (Player) sender;

                        // Toggle flying mode for player
                        player.setAllowFlight(!player.getAllowFlight());
                        player.setFlying(player.getAllowFlight());

                        // Send message to player
                        String message = player.getAllowFlight() ? "Fly mode enabled." : "Fly mode disabled.";
                        player.sendMessage(message);

                        return true;
                    }
                }
            }
