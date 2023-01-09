# git-innit-2023
git innit 2023 submission - Minecraft Balanced Nutrition

Run it like any other minecraft plugin. version 1.19 and below, certain food items may not work in lower versions.

Commands:
/info            to get a summary of what this project is about
/healthstats     to see your nutritional statistics

There are five categories of nutritions
Fat, Sugar, Sodium, Carb, Protein

Each food item in minecraft were giving a rating for each category
APPLE: [0,3,0,1,0]
MUSHROOM_STEW: [2,0,2,2,2]
BREAD: [1,2,1,4,3]
PORKCHOP: [3,0,2,1,3]
COOKED_PORKCHOP: [3,0,2,1,3]
COD: [2,0,2,1,3]
SALMON: [4,0,2,0,2]
TROPICAL_FISH: [2,0,2,0,2]
PUFFERFISH: [1,0,2,0,2]
COOKED_COD: [2,0,2,1,3]
COOKED_SALMON: [4,0,2,0,2]
COOKIE: [2,4,1,3,2]
MELON_SLICE: [0,3,0,2,1]
DRIED_KELP: [2,2,4,2,2]
BEEF: [3,0,2,2,3]
COOKED_BEEF: [3,0,2,2,3]
CHICKEN: [2,0,2,1,2]
COOKED_CHICKEN: [2,0,2,1,2]
ROTTEN_FLESH: [1,0,1,1,1]
SPIDER_EYE: [1,0,1,1,2]
CARROT: [0,2,1,3,1]
POTATO: [0,1,0,4,1]
BAKED_POTATO: [0,3,0,1,0]
POISONOUS_POTATO: [0,3,0,1,0]
PUMPKIN_PIE: [0,3,0,1,0]
RABBIT: [0,3,0,1,0]
COOKED_RABBIT: [0,3,0,1,0]
RABBIT STEW: [0,3,0,1,0]
MUTTON: [0,3,0,1,0]
COOKED_MUTTON: [0,3,0,1,0]
CHORUS_FRUIT: [0,3,0,1,0]
BEETROOT: [0,3,0,1,0]
BEETROOT_SOUP: [0,3,0,1,0]
SUSPICIOUS_STEW: [0,3,0,1,0]
SWEET_BERRIES: [0,3,0,1,0]
GLOW_BERRIES: [0,3,0,1,0]
HONEY_BOTTLE: [0,3,0,1,0]
CAKE: [0,3,0,1,0]

Each time you eat a food item your starting rating og [100,100,100,100,100] will drop by 2
Resulting in [98,98,98,98,98], and then the stats of the food eaten will be added for the final result
For example of you eat an apple, your new stat will be [98,101,98,99,98]
This shows tha you are high in sugar and low on protein and fat after you ate an apple

If certain stats go too far beyond what was considered healthy, you will get sick and be applied with debuffs
High Fat: Heart Attack
Low Fat: Weakened body and immune system
High Sugar: Diabetes and reduced healing
Low Sugar: Loss of coordination
High Sodium: Hypertension
Low Sodium: Nausea and Dizzyness
High Carb: Obese and loss of mobility
Low Carb: Vision loss
High Protein: Chronic Headache
Low Protein: Loss of Muscle Control

Many bugs (un)discovered & unpatched!
