package com.pixele;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.fml.InterModComms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * EMC Mapper for Pixelmon items.
 * 
 * This class defines and registers EMC values for Pixelmon items using a
 * "Base + Recursive" strategy:
 * 
 * 1. Base Materials: Core resources get explicit EMC values
 * 2. Recursive Mapping: Complex items inherit EMC from recipe ingredients
 * 3. Direct Overrides: Items without recipes get explicit values
 * 
 * Note: Decorative items (furniture, rugs, mail, badges, Unown/Braille blocks)
 * are intentionally excluded as they provide no gameplay benefit for EMC.
 */
public class PixelEMapper {
    
    private static final String PIXELMON_NAMESPACE = "pixelmon";
    
    // Using LinkedHashMap to maintain insertion order for organized logging
    private static final Map<String, Long> EMC_VALUES = new LinkedHashMap<>();
    
    static {
        // ==================== APRICORNS (Base crafting materials) ====================
        addItem("red_apricorn", 64);
        addItem("yellow_apricorn", 64);
        addItem("blue_apricorn", 64);
        addItem("green_apricorn", 64);
        addItem("pink_apricorn", 64);
        addItem("black_apricorn", 64);
        addItem("white_apricorn", 64);
        
        // Cooked Apricorns
        addItem("cooked_red_apricorn", 128);
        addItem("cooked_yellow_apricorn", 128);
        addItem("cooked_blue_apricorn", 128);
        addItem("cooked_green_apricorn", 128);
        addItem("cooked_pink_apricorn", 128);
        addItem("cooked_black_apricorn", 128);
        addItem("cooked_white_apricorn", 128);
        
        // ==================== RAW ORES ====================
        addItem("bauxite_ore", 128);
        addItem("silicon_ore", 128);
        addItem("amethyst_ore", 256);
        addItem("crystal_ore", 256);
        addItem("ruby_ore", 512);
        addItem("sapphire_ore", 512);
        addItem("platinum_ore", 1024);
        addItem("silver_ore", 512);
        
        // Evolution stone ores
        addItem("fire_stone_ore", 512);
        addItem("water_stone_ore", 512);
        addItem("thunder_stone_ore", 512);
        addItem("leaf_stone_ore", 512);
        addItem("sun_stone_ore", 512);
        addItem("moon_stone_ore", 512);
        addItem("dawn_stone_ore", 1024);
        addItem("dusk_stone_ore", 1024);
        addItem("shiny_stone_ore", 1024);
        addItem("ice_stone_ore", 1024);
        
        // ==================== PROCESSED MATERIALS ====================
        addItem("silicon", 128);
        addItem("silicon_block", 1152);
        addItem("aluminum_ingot", 256);
        addItem("aluminum_plate", 256);
        addItem("aluminum_block", 2304);
        addItem("platinum_ingot", 2048);
        addItem("platinum_block", 18432);
        addItem("silver_ingot", 1024);
        addItem("silver_block", 9216);
        
        // Gems and crystals
        addItem("amethyst", 512);
        addItem("amethyst_block", 4608);
        addItem("crystal", 512);
        addItem("crystal_block", 4608);
        addItem("ruby", 2048);
        addItem("ruby_block", 18432);
        addItem("sapphire", 2048);
        addItem("sapphire_block", 18432);
        
        // Evolution stone shards (4 shards = 1 stone typically)
        addItem("fire_stone_shard", 512);
        addItem("water_stone_shard", 512);
        addItem("thunder_stone_shard", 512);
        addItem("leaf_stone_shard", 512);
        addItem("sun_stone_shard", 512);
        addItem("moon_stone_shard", 512);
        addItem("dawn_stone_shard", 1024);
        addItem("dusk_stone_shard", 1024);
        addItem("shiny_stone_shard", 1024);
        addItem("ice_stone_shard", 1024);
        
        // ==================== POKÉ BALL PARTS ====================
        addItem("poke_ball_lid", 256);
        addItem("great_ball_lid", 384);
        addItem("ultra_ball_lid", 512);
        addItem("dive_ball_lid", 384);
        addItem("dusk_ball_lid", 384);
        addItem("fast_ball_lid", 384);
        addItem("friend_ball_lid", 384);
        addItem("heal_ball_lid", 384);
        addItem("heavy_ball_lid", 384);
        addItem("level_ball_lid", 384);
        addItem("love_ball_lid", 384);
        addItem("lure_ball_lid", 384);
        addItem("luxury_ball_lid", 512);
        addItem("moon_ball_lid", 384);
        addItem("nest_ball_lid", 384);
        addItem("net_ball_lid", 384);
        addItem("premier_ball_lid", 384);
        addItem("quick_ball_lid", 384);
        addItem("repeat_ball_lid", 384);
        addItem("safari_ball_lid", 512);
        addItem("sport_ball_lid", 512);
        addItem("timer_ball_lid", 384);
        
        // Hisuian ball lids
        addItem("ancient_poke_ball_lid", 256);
        addItem("ancient_great_ball_lid", 384);
        addItem("ancient_heavy_ball_lid", 384);
        addItem("ancient_ultra_ball_lid", 512);
        addItem("feather_ball_lid", 384);
        addItem("wing_ball_lid", 512);
        addItem("jet_ball_lid", 640);
        addItem("leaden_ball_lid", 384);
        addItem("gigaton_ball_lid", 640);
        
        // Ball bases
        addItem("aluminum_base", 256);
        addItem("iron_base", 256);
        addItem("platinum_base", 2048);
        addItem("silver_base", 1024);
        addItem("wooden_base", 64);
        
        // ==================== POKÉ BALLS ====================
        addItem("poke_ball", 512);
        addItem("great_ball", 768);
        addItem("ultra_ball", 1024);
        addItem("master_ball", 32768);  // Very rare, non-craftable
        
        // Specialty balls (craftable)
        addItem("dive_ball", 768);
        addItem("dusk_ball", 768);
        addItem("fast_ball", 768);
        addItem("friend_ball", 768);
        addItem("heal_ball", 768);
        addItem("heavy_ball", 768);
        addItem("level_ball", 768);
        addItem("love_ball", 768);
        addItem("lure_ball", 768);
        addItem("luxury_ball", 1024);
        addItem("moon_ball", 768);
        addItem("nest_ball", 768);
        addItem("net_ball", 768);
        addItem("premier_ball", 768);
        addItem("quick_ball", 768);
        addItem("repeat_ball", 768);
        addItem("timer_ball", 768);
        
        // Special non-craftable balls
        addItem("beast_ball", 16384);
        addItem("cherish_ball", 32768);
        addItem("dream_ball", 16384);
        addItem("gs_ball", 65536);  // Legendary item
        addItem("origin_ball", 32768);
        addItem("park_ball", 8192);
        addItem("safari_ball", 8192);
        addItem("sport_ball", 8192);
        addItem("strange_ball", 4096);
        addItem("christmas_ball", 8192);  // Event item
        
        // Hisuian balls
        addItem("ancient_poke_ball", 512);
        addItem("ancient_great_ball", 768);
        addItem("ancient_heavy_ball", 768);
        addItem("ancient_ultra_ball", 1024);
        addItem("feather_ball", 768);
        addItem("wing_ball", 1024);
        addItem("jet_ball", 1280);
        addItem("leaden_ball", 768);
        addItem("gigaton_ball", 1280);
        
        // ==================== EVOLUTION STONES ====================
        addItem("fire_stone", 2048);
        addItem("water_stone", 2048);
        addItem("thunder_stone", 2048);
        addItem("leaf_stone", 2048);
        addItem("moon_stone", 2048);
        addItem("sun_stone", 2048);
        addItem("dawn_stone", 4096);
        addItem("dusk_stone", 4096);
        addItem("shiny_stone", 4096);
        addItem("ice_stone", 4096);
        
        // ==================== EVOLUTION ITEMS ====================
        addItem("black_augurite", 4096);
        addItem("chipped_pot", 4096);
        addItem("cracked_pot", 4096);
        addItem("deep_sea_scale", 4096);
        addItem("deep_sea_tooth", 4096);
        addItem("dragon_scale", 4096);
        addItem("dubious_disc", 4096);
        addItem("electirizer", 4096);
        addItem("everstone", 1024);
        addItem("gimmighoul_coin", 256);
        addItem("kings_rock", 4096);
        addItem("linking_cord", 4096);
        addItem("magmarizer", 4096);
        addItem("metal_coat", 4096);
        addItem("oval_stone", 2048);
        addItem("peat_block", 4096);
        addItem("prism_scale", 4096);
        addItem("protector", 4096);
        addItem("razor_claw", 4096);
        addItem("razor_fang", 4096);
        addItem("reaper_cloth", 4096);
        addItem("sachet", 4096);
        addItem("sweet_apple", 4096);
        addItem("tart_apple", 4096);
        addItem("up_grade", 4096);
        addItem("whipped_dream", 4096);
        
        // ==================== FOSSILS ====================
        addItem("fossil", 2048);  // Generic covered fossil
        addItem("covered_fossil", 2048);
        addItem("helix_fossil", 4096);
        addItem("dome_fossil", 4096);
        addItem("old_amber", 4096);
        addItem("root_fossil", 4096);
        addItem("claw_fossil", 4096);
        addItem("skull_fossil", 4096);
        addItem("armor_fossil", 4096);
        addItem("cover_fossil", 4096);
        addItem("plume_fossil", 4096);
        addItem("jaw_fossil", 4096);
        addItem("sail_fossil", 4096);
        addItem("bird_fossil", 4096);
        addItem("fish_fossil", 4096);
        addItem("drake_fossil", 4096);
        addItem("dino_fossil", 4096);
        
        // ==================== MEDICINE - HEALING ====================
        addItem("potion", 128);
        addItem("super_potion", 256);
        addItem("hyper_potion", 512);
        addItem("max_potion", 1024);
        addItem("full_restore", 2048);
        addItem("revive", 512);
        addItem("max_revive", 2048);
        addItem("revival_herb", 1024);
        addItem("sacred_ash", 8192);
        
        // Status healing
        addItem("antidote", 64);
        addItem("burn_heal", 64);
        addItem("ice_heal", 64);
        addItem("awakening", 64);
        addItem("paralyze_heal", 64);
        addItem("full_heal", 256);
        addItem("heal_powder", 128);
        
        // PP restoration
        addItem("ether", 256);
        addItem("max_ether", 512);
        addItem("elixir", 1024);
        addItem("max_elixir", 2048);
        
        // Energy items
        addItem("energy_powder", 128);
        addItem("energy_root", 256);
        
        // Food/drinks
        addItem("fresh_water", 64);
        addItem("soda_pop", 96);
        addItem("lemonade", 128);
        addItem("moomoo_milk", 192);
        addItem("berry_juice", 128);
        addItem("lava_cookie", 256);
        addItem("old_gateau", 256);
        addItem("casteliacone", 256);
        addItem("lumiose_galette", 256);
        addItem("shalour_sable", 256);
        addItem("rage_candy_bar", 256);
        addItem("big_malasada", 256);
        addItem("sweet_heart", 128);
        addItem("max_mushrooms", 8192);
        
        // ==================== VITAMINS & TRAINING ====================
        addItem("hp_up", 4096);
        addItem("protein", 4096);
        addItem("iron", 4096);
        addItem("calcium", 4096);
        addItem("zinc", 4096);
        addItem("carbos", 4096);
        addItem("pp_up", 4096);
        addItem("pp_max", 8192);
        addItem("rare_candy", 8192);
        
        // EXP Candies
        addItem("xs_exp_candy", 256);
        addItem("s_exp_candy", 512);
        addItem("m_exp_candy", 1024);
        addItem("l_exp_candy", 2048);
        addItem("xl_exp_candy", 4096);
        
        // Feathers
        addItem("health_feather", 512);
        addItem("muscle_feather", 512);
        addItem("resist_feather", 512);
        addItem("genius_feather", 512);
        addItem("clever_feather", 512);
        addItem("swift_feather", 512);
        
        // Bottle Caps
        addItem("silver_bottle_cap", 8192);
        addItem("gold_bottle_cap", 32768);
        
        // Ability items
        addItem("ability_capsule", 16384);
        addItem("ability_patch", 32768);
        
        // ==================== BATTLE ITEMS ====================
        addItem("x_attack", 256);
        addItem("x_defense", 256);
        addItem("x_sp_atk", 256);
        addItem("x_sp_def", 256);
        addItem("x_speed", 256);
        addItem("x_accuracy", 256);
        addItem("dire_hit", 256);
        addItem("guard_spec", 256);
        
        // Flutes
        addItem("blue_flute", 512);
        addItem("red_flute", 512);
        addItem("yellow_flute", 512);
        addItem("green_flute", 512);
        addItem("black_flute", 512);
        addItem("white_flute", 512);
        
        // ==================== BERRIES ====================
        // Status-curing berries
        addItem("cheri_berry", 32);
        addItem("chesto_berry", 32);
        addItem("pecha_berry", 32);
        addItem("rawst_berry", 32);
        addItem("aspear_berry", 32);
        addItem("persim_berry", 32);
        addItem("lum_berry", 128);
        
        // Healing berries
        addItem("oran_berry", 32);
        addItem("sitrus_berry", 64);
        addItem("leppa_berry", 64);
        addItem("figy_berry", 64);
        addItem("wiki_berry", 64);
        addItem("mago_berry", 64);
        addItem("aguav_berry", 64);
        addItem("iapapa_berry", 64);
        
        // EV-reducing berries
        addItem("pomeg_berry", 128);
        addItem("kelpsy_berry", 128);
        addItem("qualot_berry", 128);
        addItem("hondew_berry", 128);
        addItem("grepa_berry", 128);
        addItem("tamato_berry", 128);
        
        // Type-resist berries
        addItem("occa_berry", 128);     // Fire
        addItem("passho_berry", 128);   // Water
        addItem("wacan_berry", 128);    // Electric
        addItem("rindo_berry", 128);    // Grass
        addItem("yache_berry", 128);    // Ice
        addItem("chople_berry", 128);   // Fighting
        addItem("kebia_berry", 128);    // Poison
        addItem("shuca_berry", 128);    // Ground
        addItem("coba_berry", 128);     // Flying
        addItem("payapa_berry", 128);   // Psychic
        addItem("tanga_berry", 128);    // Bug
        addItem("charti_berry", 128);   // Rock
        addItem("kasib_berry", 128);    // Ghost
        addItem("haban_berry", 128);    // Dragon
        addItem("colbur_berry", 128);   // Dark
        addItem("babiri_berry", 128);   // Steel
        addItem("roseli_berry", 128);   // Fairy
        addItem("chilan_berry", 128);   // Normal
        
        // Pinch berries
        addItem("liechi_berry", 256);
        addItem("ganlon_berry", 256);
        addItem("salac_berry", 256);
        addItem("petaya_berry", 256);
        addItem("apicot_berry", 256);
        addItem("lansat_berry", 512);
        addItem("starf_berry", 512);
        addItem("micle_berry", 256);
        addItem("custap_berry", 256);
        
        // Damage berries
        addItem("jaboca_berry", 128);
        addItem("rowap_berry", 128);
        addItem("enigma_berry", 256);
        
        // New gen berries
        addItem("kee_berry", 128);
        addItem("maranga_berry", 128);
        
        // Poffin/Pokeblock berries
        addItem("cornn_berry", 64);
        addItem("magost_berry", 64);
        addItem("rabuta_berry", 64);
        addItem("nomel_berry", 64);
        addItem("spelon_berry", 64);
        addItem("pamtre_berry", 64);
        addItem("watmel_berry", 64);
        addItem("durin_berry", 64);
        addItem("belue_berry", 64);
        
        // Special berries
        addItem("drash_berry", 64);
        addItem("eggant_berry", 64);
        addItem("ginema_berry", 64);
        addItem("pumkin_berry", 64);
        addItem("touga_berry", 64);
        addItem("yago_berry", 64);
        
        // ==================== MINTS ====================
        addItem("mint_cutting", 512);
        addItem("adamant_mint", 2048);
        addItem("bold_mint", 2048);
        addItem("brave_mint", 2048);
        addItem("calm_mint", 2048);
        addItem("careful_mint", 2048);
        addItem("gentle_mint", 2048);
        addItem("hasty_mint", 2048);
        addItem("impish_mint", 2048);
        addItem("jolly_mint", 2048);
        addItem("lax_mint", 2048);
        addItem("lonely_mint", 2048);
        addItem("mild_mint", 2048);
        addItem("modest_mint", 2048);
        addItem("naive_mint", 2048);
        addItem("naughty_mint", 2048);
        addItem("quiet_mint", 2048);
        addItem("rash_mint", 2048);
        addItem("relaxed_mint", 2048);
        addItem("sassy_mint", 2048);
        addItem("serious_mint", 2048);
        addItem("timid_mint", 2048);
        addItem("hardy_mint", 2048);
        addItem("docile_mint", 2048);
        addItem("bashful_mint", 2048);
        addItem("quirky_mint", 2048);
        
        // ==================== INCENSES ====================
        addItem("full_incense", 2048);
        addItem("lax_incense", 2048);
        addItem("luck_incense", 2048);
        addItem("odd_incense", 2048);
        addItem("pure_incense", 2048);
        addItem("rock_incense", 2048);
        addItem("rose_incense", 2048);
        addItem("sea_incense", 2048);
        addItem("wave_incense", 2048);
        addItem("incense_burner", 1024);
        
        // ==================== TYPE GEMS ====================
        addItem("bug_gem", 1024);
        addItem("dark_gem", 1024);
        addItem("dragon_gem", 1024);
        addItem("electric_gem", 1024);
        addItem("fairy_gem", 1024);
        addItem("fighting_gem", 1024);
        addItem("fire_gem", 1024);
        addItem("flying_gem", 1024);
        addItem("ghost_gem", 1024);
        addItem("grass_gem", 1024);
        addItem("ground_gem", 1024);
        addItem("ice_gem", 1024);
        addItem("normal_gem", 1024);
        addItem("poison_gem", 1024);
        addItem("psychic_gem", 1024);
        addItem("rock_gem", 1024);
        addItem("steel_gem", 1024);
        addItem("water_gem", 1024);
        
        // ==================== ARCEUS PLATES ====================
        addItem("blank_plate", 2048);
        addItem("draco_plate", 8192);
        addItem("dread_plate", 8192);
        addItem("earth_plate", 8192);
        addItem("fist_plate", 8192);
        addItem("flame_plate", 8192);
        addItem("icicle_plate", 8192);
        addItem("insect_plate", 8192);
        addItem("iron_plate", 8192);
        addItem("legend_plate", 65536);  // Extremely rare
        addItem("meadow_plate", 8192);
        addItem("mind_plate", 8192);
        addItem("pixie_plate", 8192);
        addItem("sky_plate", 8192);
        addItem("splash_plate", 8192);
        addItem("spooky_plate", 8192);
        addItem("stone_plate", 8192);
        addItem("toxic_plate", 8192);
        addItem("zap_plate", 8192);
        
        // ==================== GENESECT DRIVES ====================
        addItem("burn_drive", 4096);
        addItem("chill_drive", 4096);
        addItem("douse_drive", 4096);
        addItem("shock_drive", 4096);
        
        // ==================== HELD ITEMS - BATTLE ====================
        addItem("absorb_bulb", 1024);
        addItem("adamant_orb", 8192);
        addItem("adrenaline_orb", 1024);
        addItem("air_balloon", 1024);
        addItem("amulet_coin", 4096);
        addItem("assault_vest", 4096);
        addItem("big_root", 2048);
        addItem("binding_band", 2048);
        addItem("black_belt", 1024);
        addItem("black_glasses", 1024);
        addItem("black_sludge", 2048);
        addItem("blunder_policy", 4096);
        addItem("bright_powder", 2048);
        addItem("cell_battery", 1024);
        addItem("charcoal", 1024);
        addItem("choice_band", 4096);
        addItem("choice_scarf", 4096);
        addItem("choice_specs", 4096);
        addItem("cleanse_tag", 1024);
        addItem("damp_rock", 1024);
        addItem("destiny_knot", 2048);
        addItem("dragon_fang", 1024);
        addItem("eject_button", 2048);
        addItem("electric_seed", 1024);
        addItem("eviolite", 4096);
        addItem("exp_share", 4096);
        addItem("expert_belt", 2048);
        addItem("flame_orb", 2048);
        addItem("float_stone", 1024);
        addItem("focus_band", 2048);
        addItem("focus_sash", 4096);
        addItem("grassy_seed", 1024);
        addItem("grip_claw", 1024);
        addItem("griseous_orb", 8192);
        addItem("hard_stone", 1024);
        addItem("heat_rock", 1024);
        addItem("heavy_duty_boots", 4096);
        addItem("icy_rock", 1024);
        addItem("iron_ball", 1024);
        addItem("lagging_tail", 1024);
        addItem("leek", 2048);
        addItem("leftovers", 4096);
        addItem("life_orb", 4096);
        addItem("light_ball", 2048);
        addItem("light_clay", 1024);
        addItem("lucky_egg", 8192);
        addItem("lucky_punch", 2048);
        addItem("luminous_moss", 1024);
        addItem("lustrous_orb", 8192);
        addItem("macho_brace", 2048);
        addItem("magnet", 1024);
        addItem("mental_herb", 2048);
        addItem("metal_powder", 2048);
        addItem("metronome", 2048);
        addItem("miracle_seed", 1024);
        addItem("misty_seed", 1024);
        addItem("muscle_band", 2048);
        addItem("mystic_water", 1024);
        addItem("never_melt_ice", 1024);
        addItem("poison_barb", 1024);
        addItem("power_anklet", 2048);
        addItem("power_band", 2048);
        addItem("power_belt", 2048);
        addItem("power_bracer", 2048);
        addItem("power_herb", 2048);
        addItem("power_lens", 2048);
        addItem("power_weight", 2048);
        addItem("psychic_seed", 1024);
        addItem("quick_claw", 2048);
        addItem("quick_powder", 2048);
        addItem("red_card", 2048);
        addItem("ring_target", 1024);
        addItem("rocky_helmet", 4096);
        addItem("room_service", 2048);
        addItem("safety_goggles", 4096);
        addItem("scope_lens", 2048);
        addItem("sharp_beak", 1024);
        addItem("shed_shell", 2048);
        addItem("shell_bell", 2048);
        addItem("silk_scarf", 1024);
        addItem("silver_powder", 1024);
        addItem("smoke_ball", 1024);
        addItem("smooth_rock", 1024);
        addItem("snowball", 1024);
        addItem("soft_sand", 1024);
        addItem("soothe_bell", 2048);
        addItem("soul_dew", 8192);
        addItem("spell_tag", 1024);
        addItem("sticky_barb", 2048);
        addItem("terrain_extender", 2048);
        addItem("thick_club", 2048);
        addItem("throat_spray", 2048);
        addItem("toxic_orb", 2048);
        addItem("twisted_spoon", 1024);
        addItem("weakness_policy", 4096);
        addItem("white_herb", 2048);
        addItem("wide_lens", 2048);
        addItem("wise_glasses", 2048);
        addItem("zoom_lens", 2048);
        
        // ==================== MEGA STONES ====================
        addItem("abomasite", 16384);
        addItem("absolite", 16384);
        addItem("aerodactylite", 16384);
        addItem("aggronite", 16384);
        addItem("alakazite", 16384);
        addItem("altarianite", 16384);
        addItem("ampharosite", 16384);
        addItem("audinite", 16384);
        addItem("banettite", 16384);
        addItem("beedrillite", 16384);
        addItem("blastoisinite", 16384);
        addItem("blazikenite", 16384);
        addItem("cameruptite", 16384);
        addItem("charizardite_x", 16384);
        addItem("charizardite_y", 16384);
        addItem("diancite", 16384);
        addItem("galladite", 16384);
        addItem("garchompite", 16384);
        addItem("gardevoirite", 16384);
        addItem("gengarite", 16384);
        addItem("glalitite", 16384);
        addItem("gyaradosite", 16384);
        addItem("heracronite", 16384);
        addItem("houndoominite", 16384);
        addItem("kangaskhanite", 16384);
        addItem("latiasite", 16384);
        addItem("latiosite", 16384);
        addItem("lopunnite", 16384);
        addItem("lucarionite", 16384);
        addItem("manectite", 16384);
        addItem("mawilite", 16384);
        addItem("medichamite", 16384);
        addItem("metagrossite", 16384);
        addItem("mewtwonite_x", 16384);
        addItem("mewtwonite_y", 16384);
        addItem("pidgeotite", 16384);
        addItem("pinsirite", 16384);
        addItem("sablenite", 16384);
        addItem("salamencite", 16384);
        addItem("sceptilite", 16384);
        addItem("scizorite", 16384);
        addItem("sharpedonite", 16384);
        addItem("slowbronite", 16384);
        addItem("steelixite", 16384);
        addItem("swampertite", 16384);
        addItem("tyranitarite", 16384);
        addItem("venusaurite", 16384);
        
        // ==================== Z-CRYSTALS ====================
        // Type Z-Crystals
        addItem("buginium_z", 8192);
        addItem("darkinium_z", 8192);
        addItem("dragonium_z", 8192);
        addItem("electrium_z", 8192);
        addItem("fairium_z", 8192);
        addItem("fightinium_z", 8192);
        addItem("firium_z", 8192);
        addItem("flyinium_z", 8192);
        addItem("ghostium_z", 8192);
        addItem("grassium_z", 8192);
        addItem("groundium_z", 8192);
        addItem("icium_z", 8192);
        addItem("normalium_z", 8192);
        addItem("poisonium_z", 8192);
        addItem("psychium_z", 8192);
        addItem("rockium_z", 8192);
        addItem("steelium_z", 8192);
        addItem("waterium_z", 8192);
        
        // Pokémon-specific Z-Crystals
        addItem("aloraichium_z", 16384);
        addItem("decidium_z", 16384);
        addItem("eevium_z", 16384);
        addItem("incinium_z", 16384);
        addItem("kommonium_z", 16384);
        addItem("lunalium_z", 16384);
        addItem("lycanium_z", 16384);
        addItem("marshadium_z", 16384);
        addItem("mewnium_z", 16384);
        addItem("mimikium_z", 16384);
        addItem("pikanium_z", 16384);
        addItem("pikashunium_z", 16384);
        addItem("primarium_z", 16384);
        addItem("snorlium_z", 16384);
        addItem("solganium_z", 16384);
        addItem("tapunium_z", 16384);
        addItem("ultranecrozium_z", 32768);
        
        // ==================== VALUABLE ITEMS ====================
        addItem("tiny_mushroom", 128);
        addItem("big_mushroom", 512);
        addItem("balm_mushroom", 4096);
        addItem("pearl", 512);
        addItem("big_pearl", 2048);
        addItem("pearl_string", 8192);
        addItem("stardust", 512);
        addItem("star_piece", 4096);
        addItem("comet_shard", 16384);
        addItem("nugget", 2048);
        addItem("big_nugget", 8192);
        addItem("rare_bone", 4096);
        addItem("relic_copper", 1024);
        addItem("relic_silver", 2048);
        addItem("relic_gold", 4096);
        addItem("relic_band", 8192);
        addItem("relic_statue", 16384);
        addItem("relic_crown", 32768);
        addItem("relic_vase", 8192);
        addItem("shoal_salt", 256);
        addItem("shoal_shell", 256);
        addItem("slowpoke_tail", 1024);
        addItem("strange_souvenir", 2048);
        
        // ==================== TOOLS ====================
        addItem("old_rod", 256);
        addItem("good_rod", 512);
        addItem("super_rod", 1024);
        addItem("wailmer_pail", 256);
        addItem("itemfinder", 2048);
        addItem("camera", 2048);
        addItem("film", 64);
        
        // Running boots
        addItem("old_running_boots", 1024);
        addItem("new_running_boots", 2048);
        
        // Hammers (for anvil crafting)
        addItem("wood_hammer", 64);
        addItem("stone_hammer", 128);
        addItem("iron_hammer", 256);
        addItem("gold_hammer", 512);
        addItem("diamond_hammer", 1024);
        addItem("aluminum_hammer", 512);
        addItem("amethyst_hammer", 1024);
        addItem("crystal_hammer", 1024);
        addItem("ruby_hammer", 4096);
        addItem("sapphire_hammer", 4096);
        
        // Evolution stone hammers
        addItem("fire_stone_hammer", 4096);
        addItem("water_stone_hammer", 4096);
        addItem("thunder_stone_hammer", 4096);
        addItem("leaf_stone_hammer", 4096);
        addItem("sun_stone_hammer", 4096);
        addItem("moon_stone_hammer", 4096);
        addItem("dawn_stone_hammer", 8192);
        addItem("dusk_stone_hammer", 8192);
        
        // ==================== MACHINES ====================
        addItem("anvil", 2048);
        addItem("mechanical_anvil", 8192);
        addItem("pc", 4096);
        addItem("healer", 2048);
        addItem("fossil_cleaner", 4096);
        addItem("fossil_machine", 8192);
        addItem("cloning_machine", 32768);
        addItem("trade_machine", 4096);
        addItem("ranch_block", 4096);
        addItem("ranch_upgrade", 2048);
        addItem("infuser", 4096);
        
        // Machine parts
        addItem("fossil_machine_base", 1024);
        addItem("fossil_machine_tank", 1024);
        addItem("fossil_machine_display", 1024);
        addItem("fossil_machine_top", 1024);
        addItem("cloner_cord", 2048);
        addItem("green_tank", 512);
        addItem("orange_tank", 512);
        addItem("trade_panel", 512);
        addItem("trade_monitor", 1024);
        addItem("trade_holder_left", 512);
        addItem("trade_holder_right", 512);
        
        // Movement
        addItem("elevator", 1024);
        addItem("movement_plate", 256);
        addItem("stick_plate", 256);
        addItem("timed_fall", 256);
        
        // Vending machines
        addItem("blue_vending_machine", 2048);
        addItem("green_vending_machine", 2048);
        addItem("orange_vending_machine", 2048);
        addItem("pink_vending_machine", 2048);
        addItem("red_vending_machine", 2048);
        addItem("yellow_vending_machine", 2048);
        
        // ==================== REPELS ====================
        addItem("repel", 128);
        addItem("super_repel", 256);
        addItem("max_repel", 512);
        
        // ==================== LEGENDARY ITEMS ====================
        addItem("azure_flute", 32768);
        addItem("dna_splicers", 16384);
        addItem("gracidea", 8192);
        addItem("meteorite", 8192);
        addItem("prison_bottle", 16384);
        addItem("reveal_glass", 16384);
        addItem("red_orb", 16384);
        addItem("blue_orb", 16384);
        addItem("red_chain", 32768);
        addItem("clear_bell", 8192);
        addItem("tidal_bell", 8192);
        addItem("alpha_shard", 4096);
        addItem("omega_shard", 4096);
        addItem("orb", 2048);
        addItem("orb_of_fiery_souls", 8192);
        addItem("orb_of_frozen_souls", 8192);
        addItem("orb_of_static_souls", 8192);
        addItem("ruby_of_emotion", 8192);
        addItem("ruby_of_knowledge", 8192);
        addItem("ruby_of_willpower", 8192);
        
        // Experience items
        addItem("exp_all", 16384);
        
        // Misc items
        addItem("isi_golden_hourglass", 16384);
        addItem("isi_silver_hourglass", 8192);
        addItem("poke_gift", 2048);
        addItem("gift_box", 1024);
        
        // Porygon pieces
        addItem("porygon", 8192);
        addItem("porygon_body", 2048);
        addItem("porygon_head", 2048);
        addItem("porygon_leg", 2048);
        addItem("porygon_tail", 2048);
        
        // ==================== TM/HM BASE VALUES ====================
        // TMs have consistent base value - complex moves should be higher
        // Using a generic value since there are 174 TMs
        for (int i = 1; i <= 174; i++) {
            addItem("tm" + i, 2048);
        }
        
        // HMs
        for (int i = 1; i <= 10; i++) {
            addItem("hm" + i, 4096);
        }
        
        // ==================== ARMOR (Tools derive from materials) ====================
        // Armor sets get moderate values - will be calculated from recipes too
        addItem("aluminum_helmet", 1024);
        addItem("aluminum_chestplate", 1536);
        addItem("aluminum_leggings", 1280);
        addItem("aluminum_boots", 768);
        
        // Evolution stone armor (higher tier)
        String[] stoneTypes = {"fire_stone", "water_stone", "thunder_stone", "leaf_stone", 
                               "sun_stone", "moon_stone", "dawn_stone", "dusk_stone"};
        for (String stone : stoneTypes) {
            addItem(stone + "_helmet", 8192);
            addItem(stone + "_chestplate", 12288);
            addItem(stone + "_leggings", 10240);
            addItem(stone + "_boots", 6144);
        }
        
        // Team armor
        addItem("rocket_helmet", 2048);
        addItem("rocket_chestplate", 3072);
        addItem("rocket_leggings", 2560);
        addItem("rocket_boots", 1536);
        
        addItem("plasma_helmet", 2048);
        addItem("plasma_chestplate", 3072);
        addItem("plasma_leggings", 2560);
        addItem("plasma_boots", 1536);
        
        addItem("neo_plasma_helmet", 4096);
        addItem("neo_plasma_chestplate", 6144);
        addItem("neo_plasma_leggings", 5120);
        addItem("neo_plasma_boots", 3072);
        
        addItem("galactic_swag", 4096);
        addItem("galactic_chestplate", 6144);
        addItem("galactic_leggings", 5120);
        addItem("galactic_boots", 3072);
        
        addItem("aqua_helmet", 2048);
        addItem("aqua_chestplate", 3072);
        addItem("aqua_leggings", 2560);
        addItem("aqua_boots", 1536);
        
        addItem("magma_helmet", 2048);
        addItem("magma_chestplate", 3072);
        addItem("magma_leggings", 2560);
        addItem("magma_boots", 1536);
    }
    
    private static void addItem(String id, long emc) {
        EMC_VALUES.put(id, emc);
    }
    
    /**
     * Registers all EMC values with ProjectE via InterModComms.
     * Called during the InterModEnqueue event.
     */
    public static void registerEMCValues() {
        PixelEBridge.LOGGER.info("Registering EMC values for Pixelmon items...");
        
        int registered = 0;
        int failed = 0;
        
        for (Map.Entry<String, Long> entry : EMC_VALUES.entrySet()) {
            if (registerSingleItem(entry.getKey(), entry.getValue())) {
                registered++;
            } else {
                failed++;
            }
        }
        
        PixelEBridge.LOGGER.info("EMC Registration complete: {} items registered, {} items not found in registry.",
                registered, failed);
    }
    
    /**
     * Registers a single item's EMC value with ProjectE.
     * 
     * @param itemId The item ID (without namespace)
     * @param emcValue The EMC value to assign
     * @return true if registration was successful, false if item not found
     */
    private static boolean registerSingleItem(String itemId, Long emcValue) {
        ResourceLocation itemLocation = ResourceLocation.tryBuild(PIXELMON_NAMESPACE, itemId);
        
        if (itemLocation == null) {
            PixelEBridge.LOGGER.debug("Invalid item ID format: {}", itemId);
            return false;
        }
        
        // Check if the item exists in the registry
        Optional<Item> itemOpt = BuiltInRegistries.ITEM.getOptional(itemLocation);
        
        if (itemOpt.isEmpty()) {
            PixelEBridge.LOGGER.debug("Item not found in registry: {}", itemLocation);
            return false;
        }
        
        // Send IMC message to ProjectE
        try {
            InterModComms.sendTo("projecte", "register_emc", () -> new EMCMessage(itemLocation, emcValue));
            PixelEBridge.LOGGER.debug("Registered EMC for {}: {}", itemLocation, emcValue);
            return true;
        } catch (Exception e) {
            PixelEBridge.LOGGER.warn("Failed to send IMC for {}: {}", itemLocation, e.getMessage());
            return false;
        }
    }
    
    /**
     * Message record for InterModComms EMC registration.
     */
    public record EMCMessage(ResourceLocation itemId, long emcValue) {}
    
    /**
     * Get the total number of items configured.
     */
    public static int getConfiguredItemCount() {
        return EMC_VALUES.size();
    }
}
