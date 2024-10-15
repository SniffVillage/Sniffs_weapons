package nl.sniffiandros.sniffsweapons.misc;

import net.minecraft.client.gui.components.TextAndImageButton;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.server.command.TextComponentHelper;
import nl.sniffiandros.sniffsweapons.Config;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ItemNameGenerator {

    public static List<String> classes() {
        List<String> classes = new ArrayList<>();
        classes.add("naming.sniffsweapons.class.king");
        classes.add("naming.sniffsweapons.class.emperor");
        classes.add("naming.sniffsweapons.class.prince");
        classes.add("naming.sniffsweapons.class.lord");
        classes.add("naming.sniffsweapons.class.apprentice");
        classes.add("naming.sniffsweapons.class.knight");
        classes.add("naming.sniffsweapons.class.god");
        return classes;
    }

    public static List<String> stories() {
        List<String> stories = new ArrayList<>();
        stories.add("naming.sniffsweapons.story.long_lost");
        stories.add("naming.sniffsweapons.story.forbidden");
        stories.add("naming.sniffsweapons.story.cursed");
        stories.add("naming.sniffsweapons.story.banished");
        stories.add("naming.sniffsweapons.story.almighty");
        stories.add("naming.sniffsweapons.story.heroic");
        stories.add("naming.sniffsweapons.story.legendary");
        stories.add("naming.sniffsweapons.story.powerful");
        stories.add("naming.sniffsweapons.story.weak");
        stories.add("naming.sniffsweapons.story.wacky");
        stories.add("naming.sniffsweapons.story.hellish");
        stories.add("naming.sniffsweapons.story.godly");
        stories.add("naming.sniffsweapons.story.heavy");
        stories.add("naming.sniffsweapons.story.wrought");
        return stories;
    }

    public static List<String> names() {
        List<String> names = new ArrayList<>();
        names.add("entity.minecraft.piglin");
        names.add("naming.sniffsweapons.name.bob");
        names.add("entity.minecraft.pillager");
        names.add("entity.minecraft.villager");
        names.add("naming.sniffsweapons.name.chotmas");
        names.add("naming.sniffsweapons.name.rastora");
        names.add("naming.sniffsweapons.name.hartokor");
        names.add("naming.sniffsweapons.name.feskhi");
        names.add("naming.sniffsweapons.name.riskhopeph");
        names.add("naming.sniffsweapons.name.viscosjev");
        names.add("naming.sniffsweapons.name.bacripps");
        names.add("naming.sniffsweapons.name.felips");
        names.add("naming.sniffsweapons.name.hank");
        names.add("naming.sniffsweapons.name.steven");
        names.add("naming.sniffsweapons.name.willem");
        names.add("naming.sniffsweapons.name.william");
        names.add("naming.sniffsweapons.name.john");
        names.add("naming.sniffsweapons.name.robin");
        names.add("naming.sniffsweapons.name.oliver");
        names.add("naming.sniffsweapons.name.ragnar");
        names.add("naming.sniffsweapons.name.igor");
        names.add("naming.sniffsweapons.name.norman");
        names.add("naming.sniffsweapons.name.thoren");
        names.add("naming.sniffsweapons.name.agar");
        names.add("naming.sniffsweapons.name.heimdall");
        names.add("naming.sniffsweapons.name.olin");
        names.add("naming.sniffsweapons.name.nhor");
        names.add("naming.sniffsweapons.name.meinir");
        names.add("naming.sniffsweapons.name.xi");
        names.add("naming.sniffsweapons.name.hojo");
        names.add("naming.sniffsweapons.name.jin");
        names.add("naming.sniffsweapons.name.kage");
        return names;
    }

    public static List<String> sec_names() {
        List<String> sec_names = new ArrayList<>();
        sec_names.add("naming.sniffsweapons.name.the_annihilator");
        sec_names.add("naming.sniffsweapons.name.the_wonderful");
        sec_names.add("naming.sniffsweapons.name.the_great");
        sec_names.add("naming.sniffsweapons.name.the_beauty");
        sec_names.add("naming.sniffsweapons.name.the_unholy");
        sec_names.add("naming.sniffsweapons.name.the_sophisticated");
        sec_names.add("naming.sniffsweapons.name.the_holy");
        sec_names.add("naming.sniffsweapons.name.the_grand");
        sec_names.add("naming.sniffsweapons.name.the_magnificent");
        sec_names.add("naming.sniffsweapons.name.the_majestic");
        sec_names.add("naming.sniffsweapons.name.the_blight");
        sec_names.add("naming.sniffsweapons.name.the_great_spatula");
        sec_names.add("naming.sniffsweapons.name.alexander");
        sec_names.add("naming.sniffsweapons.name.jobs");
        sec_names.add("naming.sniffsweapons.name.jansen");
        sec_names.add("naming.sniffsweapons.name.spentova");
        sec_names.add("naming.sniffsweapons.name.achard");
        sec_names.add("naming.sniffsweapons.name.mestofa");
        sec_names.add("naming.sniffsweapons.name.reimington");
        sec_names.add("naming.sniffsweapons.name.ironbash");
        sec_names.add("naming.sniffsweapons.name.longwood");
        sec_names.add("naming.sniffsweapons.name.highlands");
        sec_names.add("naming.sniffsweapons.name.briklestorm");
        sec_names.add("naming.sniffsweapons.name.snatfitcht");
        sec_names.add("naming.sniffsweapons.name.sakai");
        sec_names.add("naming.sniffsweapons.name.tokimune");

        return sec_names;
    }

    public static List<String> count() {
        List<String> count = new ArrayList<>();
        count.add("enchantment.level.1");
        count.add("enchantment.level.2");
        count.add("enchantment.level.3");
        count.add("enchantment.level.4");
        count.add("enchantment.level.5");
        count.add("");
        return count;
    }

    public static String generate(ItemStack stack, RandomSource source) {
        List<String> classes = new ArrayList<>(Config.NAME_CLASSES.get());
        List<String> stories = new ArrayList<>(Config.NAME_STORIES.get());
        List<String> names = new ArrayList<>(Config.NAME_NAMES.get());
        List<String> sec_names = new ArrayList<>(Config.NAME_SEC_NAMES.get());
        List<String> count = new ArrayList<>(Config.NAME_COUNT.get());


        String name = Component.translatable(names.get(source.nextInt(names.size()))).getString();
        String sec_name = Component.translatable(sec_names.get(source.nextInt(sec_names.size()))).getString();
        String story = Component.translatable(stories.get(source.nextInt(stories.size()))).getString();
        String class_ = Component.translatable(classes.get(source.nextInt(classes.size()))).getString();
        String many = Component.translatable(count.get(source.nextInt(count.size()))).getString();
        String the = Component.translatable("naming.sniffsweapons.name.the").getString();
        String of = Component.translatable("naming.sniffsweapons.name.of").getString();

        return the  + " " + story + " " + stack.getHoverName().getString() + " " + of  + " " + class_ + " " + name + " " + sec_name + " " + many;
    }
}
