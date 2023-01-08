package minecraftNutrition;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

public final class MinecraftNutrition extends JavaPlugin implements CommandExecutor {


    Map map;

    static MinecraftNutrition instance;
    NutritionValues nv = new NutritionValues();
    Book b = new Book();

    public static MinecraftNutrition getInstance() {
        return instance;
    }

    File customFile = new File(getDataFolder(), "playerData.yml");
    FileConfiguration customConfig = YamlConfiguration.loadConfiguration(customFile);

    public List<Integer> getList(Player p) {
        List<Integer> list = customConfig.getIntegerList(p.getUniqueId().toString());
        return list;


    }

    @Override
    public void onEnable() {

        instance = this;

        File customFile = new File(getDataFolder(), "playerData.yml");
        FileConfiguration customConfig;
        if (customFile != null) {
            customConfig = YamlConfiguration.loadConfiguration(customFile);
        } else {
            customConfig = new YamlConfiguration();
        }


        getServer().getScheduler().runTaskTimer(this, new Runnable() {

            @Override
            public void run() {

                for (Player p : Bukkit.getServer().getOnlinePlayers()) {

                    List<Integer> list = nv.getList(p);
                    System.out.println(list);
                    if (list.get(0) >= 125) {

                        p.addPotionEffect((new PotionEffect(PotionEffectType.BLINDNESS, 200, 10)));
                        p.addPotionEffect((new PotionEffect(PotionEffectType.CONFUSION, 200, 10)));
                        p.playSound(p.getLocation(), Sound.ENTITY_WARDEN_HEARTBEAT, 1000, 1);
                        p.addPotionEffect((new PotionEffect(PotionEffectType.WITHER, 2000, 10)));

                    }
                    if (list.get(1) <= 76) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.WEAKNESS, 60, 1)));

                    }
                    if (list.get(2) <= 76) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.CONFUSION, 60, 1)));

                    }
                    if (list.get(3) >= 117) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 60, 1)));

                    }
                    if (list.get(3) >= 125) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.SLOW, 60, 2)));

                    }
                    if (list.get(3) <= 76) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.BLINDNESS, 20, 1)));

                    }
                    if (list.get(4) <= 76) {
                        p.addPotionEffect((new PotionEffect(PotionEffectType.SLOW_DIGGING, 60, 1)));

                    }


                }

            }
        }, 1, 30).getTaskId();


        getServer().getPluginManager().registerEvents(new NutritionValues(), this);
        //getCommand("inflict").setExecutor(this);
        //getCommand("cure").setExecutor(this);
        getCommand("healthstats").setExecutor(this);
        getCommand("info").setExecutor(this);
        getCommand("foodInfo").setExecutor(this);
        getLogger().info(ChatColor.GREEN + "Minecraft Nutrition Plugin Successfully Loaded");

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("foodinfo")) {
            sender.sendMessage(ChatColor.GREEN + "Here are a list of all the food items and their nutritional values:");
            FileConfiguration config = getConfig();
        }
        if (cmd.getName().equalsIgnoreCase("info")) {
            sender.sendMessage(ChatColor.GREEN + "The rules of this plugin is simple, to eat a balanced diet and lead a healthy life in the wonderful world of minecraft");
        }
        if (cmd.getName().equalsIgnoreCase("healthstats")) {
            if(sender instanceof ConsoleCommandSender) {
                return true;
            }

                Player p = (Player) sender;
                p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10000, 1);
                b.showData(p);
                return true;


            }





        return true;
    }


    @Override
    public void onDisable() {
        getLogger().info(ChatColor.GREEN+"Minecraft Nutrition Plugin Has Shut Down.");
    }
}
