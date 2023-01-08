package minecraftNutrition;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class NutritionValues implements Listener {

    public List<Integer> getList(Player p){
        File customFile = new File(MinecraftNutrition.getInstance().getDataFolder(), "playerData.yml");
        FileConfiguration customConfig;
        customConfig = YamlConfiguration.loadConfiguration(customFile);
        return customConfig.getIntegerList(p.getUniqueId().toString());

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        File customFile = new File(MinecraftNutrition.getInstance().getDataFolder(),"playerData.yml");
        FileConfiguration customConfig;
        customConfig = YamlConfiguration.loadConfiguration(customFile);
        if(!customConfig.contains(e.getPlayer().getUniqueId().toString())){
            List<Integer> arr = Arrays.asList(100,100,100,100,100);
            customConfig.set(e.getPlayer().getUniqueId().toString(),arr);
            try {
                customConfig.save(customFile);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent e){

        if(e.getItem() == new ItemStack(Material.ENCHANTED_GOLDEN_APPLE)){
            reset(e.getPlayer());
            return;
        }
        if(e.getItem()== new ItemStack(Material.GOLDEN_CARROT)){
            reset(e.getPlayer());
            return;

        }
        if(e.getItem()== new ItemStack(Material.GOLDEN_APPLE)){
            reset(e.getPlayer());
            return;

        }
        List<Integer> list = MinecraftNutrition.getInstance().getConfig().getIntegerList(e.getItem().getType().toString());
        File customFile = new File(MinecraftNutrition.getInstance().getDataFolder(), "playerData.yml");
        FileConfiguration config;
        config = YamlConfiguration.loadConfiguration(customFile);
        List<Integer> list2 = config.getIntegerList(e.getPlayer().getUniqueId().toString());
        int[] arr = new int[5];
        for(int i=0; i<5; i++){

            list2.set(i, list2.get(i)+list.get(i)-2);
            arr[i]=list2.get(i)+list.get(i)-2;
            config.set(e.getPlayer().getUniqueId().toString(),arr);
            //Bukkit.broadcastMessage(list2.get(i).toString());
            //Bukkit.broadcastMessage(list.get(i).toString());
        }
        try {
            config.save(customFile);
        } catch (IOException var7) {
            var7.printStackTrace();

        }

        int v1 = list2.get(0);
        if(v1>=110&&v1<=117){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too much fat in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Eat your "+ChatColor.BOLD+"VEGGIES!");
            if(v1>117&v1<125){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too much fat in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"The fats are severely damaging your cardiovascular system.");
                if(v1>=125){

                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too much fat in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"You are now experiencing a "+ChatColor.DARK_PURPLE+ ChatColor.BOLD+"HEART ATTACK."); //quick death basically
                }


            }

        }


        if(v1<=90&&v1>85){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too little fat in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"You need to"+ ChatColor.BOLD+ "eat more meat!");
            if(v1<=85&&v1>76){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too little fat in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"Lack of fat is causing you "+ ChatColor.BOLD+ "skin issues.");
                if(list2.get(0)<=76){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too little fat in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"Your immune system has been "+ ChatColor.BOLD+ "weakened and you will take "+ ChatColor.BOLD+ "amplified damage.");  //fake

                }

            }

        }



        //////////////////////////////////////////////


        int v2 = list2.get(1);
        if(v2>=110 && v2<=117){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too much sugar in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat less sweets bruh.");

            if(v2>117 && v2<125){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too much sugar in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are showing signs of diabetes.");
                if(v2>=125){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too way much sugar in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"You now have "+ ChatColor.BOLD+ "type 2 diabetes and reduced healing."); //fake
                }

            }

        }

        if(v2<=90&&v2>=85){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too little sugar in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat more fruits before permanent damages occur.");
            if(v2<85&&v2>76){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too little sugar in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are feeling "+ ChatColor.BOLD+ "chills in your body.");
                if(v2<=76){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too little sugar in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"Your are now suffering from lack of coordination."); //weakness
                }

            }

        }



        int v3 = list2.get(2);
        if(v3>=110&&v3<=117){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too much sodium in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat less salty food before permanent damages occur.");
            if(v3>117&&v3<125){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too much sodium in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You feel thirsty and itchy all over.");
                if(v3>=125){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too much sodium in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"You hae acquired "+ ChatColor.BOLD+ "hypertension.");

                }

            }

        }


        if(v3<=90&&v3>=85){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too little sodium in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please increase your salt intake.");

            if(v3<85&&v3>76){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too little sodium in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are experiencing "+ ChatColor.BOLD+ "muscle cramps.");

                if(v3<=76){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too little sodium in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"Your are feeling "+ ChatColor.BOLD+ "nauseated and dizzy.");  //nausea
                }

            }


        }



        int v4 = list2.get(3);
        if(v4>=110&&v4<=117){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too much carbs in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat more veggies instead of bread.");
            if(v4>117&&v4<125){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too much carbs in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are becoming "+ ChatColor.BOLD+ "overweight.");  //slow 1
                if(v4>=125){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too much carbs in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"You are now obese and "+ ChatColor.BOLD+ "struggles to move around.");  //slow 2
                }

            }

        }

        if(v4<=90&&v4>=85){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too little carbs in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat more bread.");
            if(v4<85&&v4>76){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too little carbs in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are "+ ChatColor.BOLD+ "starving.");

                if(v4<=76){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too little carbs in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"Your are suffering from "+ ChatColor.BOLD+ "vision loss.");  //blind 1
                }

            }

        }



        int v5 = list2.get(4);
        if(v5>=110&&v5<=117){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too much protein in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat "+ ChatColor.BOLD+ "more veggies instead of meat.");
            if(v5>117&&v5<125){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too much protein in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You find your heart to be beating "+ ChatColor.BOLD+ "faster than normal.");
                if(v5>=125){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too much protein in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"You are suffering from "+ ChatColor.BOLD+ "chronic headache.");
                }

            }

        }


        if(v5<=90&&v5>=85){
            e.getPlayer().sendMessage(ChatColor.RED+"You have too little protein in your diet.");
            e.getPlayer().sendMessage(ChatColor.YELLOW+"Please eat more "+ ChatColor.BOLD+ "animal products.");
            if(v5<85&&v5>76){
                e.getPlayer().sendMessage(ChatColor.RED+"You have too little protein in your diet.");
                e.getPlayer().sendMessage(ChatColor.YELLOW+"You are "+ ChatColor.BOLD+ "losing muscle mass.");
                if(v5<=76){
                    e.getPlayer().sendMessage(ChatColor.RED+"You have WAY too little protein in your diet.");
                    e.getPlayer().sendMessage(ChatColor.YELLOW+"Your muscles won't move properly and you "+ ChatColor.BOLD+ "lost some mobility."); //mine fatigue 1
                }

            }

        }


    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        reset(e.getPlayer());
    }

    public void reset(Player p){
        File customFile = new File(MinecraftNutrition.getInstance().getDataFolder(), "playerData.yml");
        FileConfiguration config;
        config = YamlConfiguration.loadConfiguration(customFile);
        List<Integer> list2 = config.getIntegerList(p.getUniqueId().toString());
        config.set(p.getUniqueId().toString(),Arrays.asList(100,100,100,100,100));
        try {
            config.save(customFile);
        } catch (IOException var7) {
            var7.printStackTrace();

        }
    }

}
