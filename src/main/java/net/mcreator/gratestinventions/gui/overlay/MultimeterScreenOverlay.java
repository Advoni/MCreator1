
package net.mcreator.gratestinventions.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.gratestinventions.procedures.MultimeterScreenDisplayOverlayIngameProcedure;
import net.mcreator.gratestinventions.GratestInventionsModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@GratestInventionsModElements.ModElement.Tag
public class MultimeterScreenOverlay extends GratestInventionsModElements.ModElement {
	public MultimeterScreenOverlay(GratestInventionsModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOW)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (MultimeterScreenDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("capacity")) + "", posX + 99, posY + 77,
						-1);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("block")) + "", posX + 99, posY + 59, -1);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("type")) + "", posX + 99, posY + 68, -1);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("charging")) + "", posX + 99, posY + 104,
						-1);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("level")) + "", posX + 99, posY + 86, -1);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("tickevent")) + "", posX + 99, posY + 95,
						-1);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("gratest_inventions:textures/pixelfail.png"));
				Minecraft.getInstance().ingameGUI.blit(posX + 99, posY + 50, 0, 0, 0, 0, 0, 0);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
