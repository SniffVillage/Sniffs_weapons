package nl.sniffiandros.sniffsweapons.reg.lootModifiers;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import nl.sniffiandros.sniffsweapons.Config;
import nl.sniffiandros.sniffsweapons.misc.ItemNameGenerator;
import nl.sniffiandros.sniffsweapons.reg.TagReg;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class AddLootTableWithNamesModifier extends LootModifier {
    public static final Supplier<Codec<AddLootTableWithNamesModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("loot_table").forGetter((m) -> m.lootTable))
                    .apply(inst, AddLootTableWithNamesModifier::new)));

    private final ResourceLocation lootTable;

    protected AddLootTableWithNamesModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }


    @Nonnull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        var lootTable = context.getLevel().getServer().getLootData().getLootTable(this.lootTable);
        ObjectArrayList<ItemStack> objectarraylist = new ObjectArrayList<>();

        lootTable.getRandomItemsRaw(context, objectarraylist::add);

        generatedLoot.addAll(objectarraylist);

        for (int i = 0; i < generatedLoot.size(); i++) {
            ItemStack stack = generatedLoot.get(i);

            float f = Config.NAMING_CHANCE.get();
            float chanceFloat = f/100;

            if (stack.is(TagReg.Items.NAMEABLE_ITEMS) && context.getRandom().nextFloat() <= chanceFloat) {
                String name =  ItemNameGenerator.generate(stack, context.getRandom());
                stack.setHoverName(Component.literal(name));
            }
        }


        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
