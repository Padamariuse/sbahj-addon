package com.jup.sbahjaddon.client.renderer;

import com.jup.sbahjaddon.entity.item.EntityUnrealAir;
import com.jup.sbahjaddon.items.SbahjItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderMinecart;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderUnrealAir<T extends EntityUnrealAir> extends Render<T>
{
	protected final Item item;
	private final RenderItem itemRenderer;
	
	protected RenderUnrealAir(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn);
        this.item = itemIn;
        this.itemRenderer = itemRendererIn;
    }

	@Override
    protected ResourceLocation getEntityTexture(T entity)
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
	
	public ItemStack getStackToRender(T entityIn)
    {
        return new ItemStack(this.item);
    }
	
	public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
	
	public static<T extends EntityUnrealAir> Factory<T> getFactory(float shadowSize)
	{
		Factory<T> factory = new Factory<T>();
		factory.shadowSize = shadowSize;
		return factory;
	}
	
	protected static class Factory<T extends EntityUnrealAir> implements IRenderFactory<T>
	{
		protected ModelBase modelBase;
		protected float shadowSize;
		@Override
		public Render<? super T> createRenderFor(RenderManager manager)
		{
			return new RenderUnrealAir<T>(manager, SbahjItems.unrealAir, Minecraft.getMinecraft().getRenderItem());
		}
	}
}
