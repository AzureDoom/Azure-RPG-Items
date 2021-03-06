package mod.azure.azurerpgitems.util;

import mod.azure.azurerpgitems.AzureRPGItemsMod;
import mod.azure.azurerpgitems.config.Config;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AzureRPGItems {
	public static Item ring;
	public static Item axe;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		for (int i = 1; i <= 43; i++)
			event.getRegistry().register(new BowItem(new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup)
					.maxDamage(Config.SERVER.BOW_MAXDAMAGE.get())).setRegistryName(location("bow" + i)));
		for (int i = 1; i <= 11; i++)
			event.getRegistry()
					.register(new SwordItem(ItemTier.DIAMOND, (20 + i) / 5, -2.4F,
							new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup)
									.maxDamage(Config.SERVER.SWORD_MAXDAMAGE.get()))
											.setRegistryName(location("sword" + i + "")));
		for (int i = 1; i <= 9; i++)
			event.getRegistry().registerAll(
					ring = new Item(new Item.Properties().group(AzureRPGItemsTab.AccessoriesItemGroup)
							.maxDamage(Config.SERVER.RING_MAXDAMAGE.get())).setRegistryName(location("ring" + i + "")),
					new BowItem(new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup)
							.maxDamage(Config.SERVER.STAFF_MAXDAMAGE.get()))
									.setRegistryName(location("staff" + i + "")));
		for (int i = 1; i <= 4; i++)
			event.getRegistry().registerAll(
					axe = new AxeItem(ItemTier.DIAMOND, (20 + i) / 5, -2.4F,
							new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup)
									.maxDamage(Config.SERVER.AXE_MAXDAMAGE.get()))
											.setRegistryName(location("axe" + i + "")),
					new ShieldItem(new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup)
							.maxDamage(Config.SERVER.SHIELD_MAXDAMAGE.get()))
									.setRegistryName(location("shield" + i + "")),
					new Item(new Item.Properties().group(AzureRPGItemsTab.WeaponItemGroup).maxDamage(1000))
							.setRegistryName(location("gem" + i + "")));
		for (int i = 1; i <= 6; i++)
			event.getRegistry()
					.registerAll(new Item(new Item.Properties().group(AzureRPGItemsTab.AccessoriesItemGroup)
							.maxDamage(Config.SERVER.NECKLACE_MAXDAMAGE.get()))
									.setRegistryName(location("necklace" + i + "")));
		event.getRegistry().register(new Item(new Item.Properties().group(AzureRPGItemsTab.AccessoriesItemGroup)
				.maxDamage(Config.SERVER.BELT_MAXDAMAGE.get())).setRegistryName(location("belt1")));
		AzureRPGItemsMod.LOGGER.info("All Items registered.");
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(AzureRPGItemsMod.MODID, name);
	}
}