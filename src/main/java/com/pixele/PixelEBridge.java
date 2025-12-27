package com.pixele;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PixelE Bridge - A compatibility mod between Pixelmon and ProjectE.
 * 
 * This mod assigns EMC (Energy-Matter Covalence) values to Pixelmon items,
 * enabling them to be transmuted using ProjectE mechanics.
 */
@Mod(PixelEBridge.MOD_ID)
public class PixelEBridge {
    
    public static final String MOD_ID = "pixele";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public PixelEBridge(IEventBus modEventBus) {
        LOGGER.info("PixelE Bridge initializing...");
        
        // Register lifecycle event listeners
        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onInterModEnqueue);
    }
    
    /**
     * Called during mod common setup phase.
     * Used for general initialization and logging.
     */
    private void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("PixelE Bridge common setup starting...");
        
        // Verify dependencies are present
        boolean pixelmonLoaded = ModList.get().isLoaded("pixelmon");
        boolean projecteLoaded = ModList.get().isLoaded("projecte");
        
        if (pixelmonLoaded && projecteLoaded) {
            LOGGER.info("Both Pixelmon and ProjectE detected. EMC integration enabled.");
        } else {
            if (!pixelmonLoaded) {
                LOGGER.warn("Pixelmon not detected! PixelE Bridge requires Pixelmon to function.");
            }
            if (!projecteLoaded) {
                LOGGER.warn("ProjectE not detected! PixelE Bridge requires ProjectE to function.");
            }
        }
    }
    
    /**
     * Called during InterModComms enqueue phase.
     * This is where we send EMC registration messages to ProjectE.
     */
    private void onInterModEnqueue(InterModEnqueueEvent event) {
        LOGGER.info("PixelE Bridge: Enqueuing InterModComms messages...");
        
        if (!ModList.get().isLoaded("projecte")) {
            LOGGER.warn("ProjectE not loaded, skipping EMC registration via IMC.");
            return;
        }
        
        try {
            // Register EMC values via the mapper
            PixelEMapper.registerEMCValues();
            LOGGER.info("PixelE Bridge: EMC values registered successfully!");
        } catch (Exception e) {
            LOGGER.error("PixelE Bridge: Failed to register EMC values!", e);
        }
    }
}
