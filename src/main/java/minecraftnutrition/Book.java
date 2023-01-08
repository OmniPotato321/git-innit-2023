package minecraftNutrition;

import jdk.internal.joptsimple.internal.Strings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Book {

    public void showData(Player p){

        File customFile = new File(MinecraftNutrition.getInstance().getDataFolder(), "playerData.yml");
        FileConfiguration customConfig = YamlConfiguration.loadConfiguration(customFile);
        String str = "";
        List<Integer> list = customConfig.getIntegerList(p.getUniqueId().toString());
        Double diff = 0.0;
        for(int i : list){
            diff = diff + abs(i - 100) ;
        }
        if(diff ==0 ){
            str="Most Excellent";
        }
        if(diff>0&&diff<=20){
            str="Very Good";
        }
        if(diff>20&&diff<=40){
            str="Decent";
        }
        if(diff>40&&diff<=60){
            str="Meh";
        }
        if(diff>60&&diff<=100){
            str="Bad";
        }
        if(diff>100){
            str="brUh Moment";
        }

        ItemStack book = new ItemStack(Material.WRITABLE_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();
        bookMeta.setTitle(ChatColor.BLUE+"Health Status: \n " + ChatColor.GREEN +str);
        ArrayList<String> pages = new ArrayList<String>();
        pages.add(ChatColor.DARK_PURPLE+"Fat%: " + list.get(0).toString()
                + "\n" + ChatColor.DARK_PURPLE + "Sugar%: "+list.get(1).toString() + "\n" +ChatColor.DARK_PURPLE+ "Sodium%: " + list.get(2).toString()
                + "\n" + ChatColor.DARK_PURPLE + "Carb%: " + list.get(3).toString() + "\n" + ChatColor.DARK_PURPLE + "Protein%: " + list.get(4).toString());
        bookMeta.setPages(pages);
        book.setItemMeta(bookMeta);
        p.getInventory().addItem(book);
    }
}
