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
 * EMC Value Tiers:
 * - Common/Base: 64-512 (Apricorns, basic berries, common items)
 * - Uncommon: 1k-4k (Cooked materials, basic balls, status heals)
 * - Rare: 8k-32k (Specialty balls, vitamins, fossils)
 * - Very Rare: 64k-128k (Evolution items, mega stones, Z-crystals)
 * - Ultra Rare: 256k-512k (Master Ball, Ability Patch, legendary items)
 * - Legendary: 1M+ (GS Ball, Legend Plate)
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
        addItem("cooked_red_apricorn", 256);
        addItem("cooked_yellow_apricorn", 256);
        addItem("cooked_blue_apricorn", 256);
        addItem("cooked_green_apricorn", 256);
        addItem("cooked_pink_apricorn", 256);
        addItem("cooked_black_apricorn", 256);
        addItem("cooked_white_apricorn", 256);
        
        // ==================== RAW ORES ====================
        addItem("bauxite_ore", 256);
        addItem("silicon_ore", 256);
        addItem("amethyst_ore", 512);
        addItem("crystal_ore", 512);
        addItem("ruby_ore", 2048);
        addItem("sapphire_ore", 2048);
        addItem("platinum_ore", 4096);
        addItem("silver_ore", 2048);
        
        // Evolution stone ores
        addItem("fire_stone_ore", 4096);
        addItem("water_stone_ore", 4096);
        addItem("thunder_stone_ore", 4096);
        addItem("leaf_stone_ore", 4096);
        addItem("sun_stone_ore", 4096);
        addItem("moon_stone_ore", 4096);
        addItem("dawn_stone_ore", 8192);
        addItem("dusk_stone_ore", 8192);
        addItem("shiny_stone_ore", 8192);
        addItem("ice_stone_ore", 8192);
        
        // ==================== PROCESSED MATERIALS ====================
        addItem("silicon", 512);
        addItem("silicon_block", 4608);
        addItem("aluminum_ingot", 1024);
        addItem("aluminum_plate", 1024);
        addItem("aluminum_block", 9216);
        addItem("platinum_ingot", 8192);
        addItem("platinum_block", 73728);
        addItem("silver_ingot", 4096);
        addItem("silver_block", 36864);
        
        // Gems and crystals
        addItem("amethyst", 2048);
        addItem("amethyst_block", 18432);
        addItem("crystal", 2048);
        addItem("crystal_block", 18432);
        addItem("ruby", 8192);
        addItem("ruby_block", 73728);
        addItem("sapphire", 8192);
        addItem("sapphire_block", 73728);
        
        // Evolution stone shards (4 shards = 1 stone typically)
        addItem("fire_stone_shard", 4096);
        addItem("water_stone_shard", 4096);
        addItem("thunder_stone_shard", 4096);
        addItem("leaf_stone_shard", 4096);
        addItem("sun_stone_shard", 4096);
        addItem("moon_stone_shard", 4096);
        addItem("dawn_stone_shard", 8192);
        addItem("dusk_stone_shard", 8192);
        addItem("shiny_stone_shard", 8192);
        addItem("ice_stone_shard", 8192);
        
        // ==================== POKÉ BALL PARTS ====================
        addItem("poke_ball_lid", 512);
        addItem("great_ball_lid", 1024);
        addItem("ultra_ball_lid", 2048);
        addItem("dive_ball_lid", 1024);
        addItem("dusk_ball_lid", 1024);
        addItem("fast_ball_lid", 1024);
        addItem("friend_ball_lid", 1024);
        addItem("heal_ball_lid", 1024);
        addItem("heavy_ball_lid", 1024);
        addItem("level_ball_lid", 1024);
        addItem("love_ball_lid", 1024);
        addItem("lure_ball_lid", 1024);
        addItem("luxury_ball_lid", 2048);
        addItem("moon_ball_lid", 1024);
        addItem("nest_ball_lid", 1024);
        addItem("net_ball_lid", 1024);
        addItem("premier_ball_lid", 1024);
        addItem("quick_ball_lid", 1024);
        addItem("repeat_ball_lid", 1024);
        addItem("safari_ball_lid", 2048);
        addItem("sport_ball_lid", 2048);
        addItem("timer_ball_lid", 1024);
        
        // Hisuian ball lids
        addItem("ancient_poke_ball_lid", 512);
        addItem("ancient_great_ball_lid", 1024);
        addItem("ancient_heavy_ball_lid", 1024);
        addItem("ancient_ultra_ball_lid", 2048);
        addItem("feather_ball_lid", 1024);
        addItem("wing_ball_lid", 2048);
        addItem("jet_ball_lid", 4096);
        addItem("leaden_ball_lid", 1024);
        addItem("gigaton_ball_lid", 4096);
        
        // Ball bases
        addItem("aluminum_base", 1024);
        addItem("iron_base", 512);
        addItem("platinum_base", 8192);
        addItem("silver_base", 4096);
        addItem("wooden_base", 128);
        
        // ==================== POKÉ BALLS ====================
        addItem("poke_ball", 2048);
        addItem("great_ball", 4096);
        addItem("ultra_ball", 8192);
        addItem("master_ball", 524288);  // 512k - Ultra rare
        
        // Specialty balls (craftable)
        addItem("dive_ball", 4096);
        addItem("dusk_ball", 4096);
        addItem("fast_ball", 4096);
        addItem("friend_ball", 4096);
        addItem("heal_ball", 4096);
        addItem("heavy_ball", 4096);
        addItem("level_ball", 4096);
        addItem("love_ball", 4096);
        addItem("lure_ball", 4096);
        addItem("luxury_ball", 8192);
        addItem("moon_ball", 4096);
        addItem("nest_ball", 4096);
        addItem("net_ball", 4096);
        addItem("premier_ball", 4096);
        addItem("quick_ball", 4096);
        addItem("repeat_ball", 4096);
        addItem("timer_ball", 4096);
        
        // Special non-craftable balls
        addItem("beast_ball", 262144);   // 256k
        addItem("cherish_ball", 524288); // 512k
        addItem("dream_ball", 262144);   // 256k
        addItem("gs_ball", 1048576);     // 1M - Legendary item
        addItem("origin_ball", 524288);  // 512k
        addItem("park_ball", 131072);    // 128k
        addItem("safari_ball", 131072);  // 128k
        addItem("sport_ball", 131072);   // 128k
        addItem("strange_ball", 65536);  // 64k
        addItem("christmas_ball", 131072); // 128k - Event item
        
        // Hisuian balls
        addItem("ancient_poke_ball", 2048);
        addItem("ancient_great_ball", 4096);
        addItem("ancient_heavy_ball", 4096);
        addItem("ancient_ultra_ball", 8192);
        addItem("feather_ball", 4096);
        addItem("wing_ball", 8192);
        addItem("jet_ball", 16384);
        addItem("leaden_ball", 4096);
        addItem("gigaton_ball", 16384);
        
        // ==================== EVOLUTION STONES ====================
        addItem("fire_stone", 16384);
        addItem("water_stone", 16384);
        addItem("thunder_stone", 16384);
        addItem("leaf_stone", 16384);
        addItem("moon_stone", 16384);
        addItem("sun_stone", 16384);
        addItem("dawn_stone", 32768);
        addItem("dusk_stone", 32768);
        addItem("shiny_stone", 32768);
        addItem("ice_stone", 32768);
        
        // ==================== EVOLUTION ITEMS ====================
        addItem("black_augurite", 65536);   // 64k
        addItem("chipped_pot", 65536);
        addItem("cracked_pot", 65536);
        addItem("deep_sea_scale", 65536);
        addItem("deep_sea_tooth", 65536);
        addItem("dragon_scale", 65536);
        addItem("dubious_disc", 65536);
        addItem("electirizer", 65536);
        addItem("everstone", 8192);
        addItem("gimmighoul_coin", 1024);
        addItem("kings_rock", 65536);
        addItem("linking_cord", 65536);
        addItem("magmarizer", 65536);
        addItem("metal_coat", 65536);
        addItem("oval_stone", 32768);
        addItem("peat_block", 65536);
        addItem("prism_scale", 65536);
        addItem("protector", 65536);
        addItem("razor_claw", 65536);
        addItem("razor_fang", 65536);
        addItem("reaper_cloth", 65536);
        addItem("sachet", 65536);
        addItem("sweet_apple", 65536);
        addItem("tart_apple", 65536);
        addItem("up_grade", 65536);
        addItem("whipped_dream", 65536);
        
        // ==================== FOSSILS ====================
        addItem("fossil", 16384);
        addItem("covered_fossil", 16384);
        addItem("helix_fossil", 65536);   // 64k - Rare
        addItem("dome_fossil", 65536);
        addItem("old_amber", 65536);
        addItem("root_fossil", 65536);
        addItem("claw_fossil", 65536);
        addItem("skull_fossil", 65536);
        addItem("armor_fossil", 65536);
        addItem("cover_fossil", 65536);
        addItem("plume_fossil", 65536);
        addItem("jaw_fossil", 65536);
        addItem("sail_fossil", 65536);
        addItem("bird_fossil", 65536);
        addItem("fish_fossil", 65536);
        addItem("drake_fossil", 65536);
        addItem("dino_fossil", 65536);
        
        // ==================== MEDICINE - HEALING ====================
        addItem("potion", 256);
        addItem("super_potion", 512);
        addItem("hyper_potion", 1024);
        addItem("max_potion", 4096);
        addItem("full_restore", 8192);
        addItem("revive", 2048);
        addItem("max_revive", 16384);
        addItem("revival_herb", 8192);
        addItem("sacred_ash", 131072);   // 128k
        
        // Status healing
        addItem("antidote", 128);
        addItem("burn_heal", 128);
        addItem("ice_heal", 128);
        addItem("awakening", 128);
        addItem("paralyze_heal", 128);
        addItem("full_heal", 1024);
        addItem("heal_powder", 512);
        
        // PP restoration
        addItem("ether", 1024);
        addItem("max_ether", 4096);
        addItem("elixir", 8192);
        addItem("max_elixir", 16384);
        
        // Energy items
        addItem("energy_powder", 512);
        addItem("energy_root", 1024);
        
        // Food/drinks
        addItem("fresh_water", 128);
        addItem("soda_pop", 192);
        addItem("lemonade", 256);
        addItem("moomoo_milk", 384);
        addItem("berry_juice", 256);
        addItem("lava_cookie", 1024);
        addItem("old_gateau", 1024);
        addItem("casteliacone", 1024);
        addItem("lumiose_galette", 1024);
        addItem("shalour_sable", 1024);
        addItem("rage_candy_bar", 1024);
        addItem("big_malasada", 1024);
        addItem("sweet_heart", 512);
        addItem("max_mushrooms", 65536);   // 64k
        
        // ==================== VITAMINS & TRAINING ====================
        addItem("hp_up", 32768);
        addItem("protein", 32768);
        addItem("iron", 32768);
        addItem("calcium", 32768);
        addItem("zinc", 32768);
        addItem("carbos", 32768);
        addItem("pp_up", 32768);
        addItem("pp_max", 65536);   // 64k
        addItem("rare_candy", 32768);  // 32k as requested
        
        // EXP Candies
        addItem("xs_exp_candy", 1024);
        addItem("s_exp_candy", 2048);
        addItem("m_exp_candy", 4096);
        addItem("l_exp_candy", 8192);
        addItem("xl_exp_candy", 16384);
        
        // Feathers
        addItem("health_feather", 2048);
        addItem("muscle_feather", 2048);
        addItem("resist_feather", 2048);
        addItem("genius_feather", 2048);
        addItem("clever_feather", 2048);
        addItem("swift_feather", 2048);
        
        // Bottle Caps
        addItem("silver_bottle_cap", 65536);   // 64k
        addItem("gold_bottle_cap", 262144);    // 256k
        
        // Ability items
        addItem("ability_capsule", 131072);    // 128k
        addItem("ability_patch", 524288);      // 512k - Ultra rare
        
        // ==================== BATTLE ITEMS ====================
        addItem("x_attack", 1024);
        addItem("x_defense", 1024);
        addItem("x_sp_atk", 1024);
        addItem("x_sp_def", 1024);
        addItem("x_speed", 1024);
        addItem("x_accuracy", 1024);
        addItem("dire_hit", 1024);
        addItem("guard_spec", 1024);
        
        // Flutes
        addItem("blue_flute", 2048);
        addItem("red_flute", 2048);
        addItem("yellow_flute", 2048);
        addItem("green_flute", 2048);
        addItem("black_flute", 2048);
        addItem("white_flute", 2048);
        
        // ==================== BERRIES ====================
        // Status-curing berries
        addItem("cheri_berry", 64);
        addItem("chesto_berry", 64);
        addItem("pecha_berry", 64);
        addItem("rawst_berry", 64);
        addItem("aspear_berry", 64);
        addItem("persim_berry", 64);
        addItem("lum_berry", 512);
        
        // Healing berries
        addItem("oran_berry", 64);
        addItem("sitrus_berry", 128);
        addItem("leppa_berry", 128);
        addItem("figy_berry", 128);
        addItem("wiki_berry", 128);
        addItem("mago_berry", 128);
        addItem("aguav_berry", 128);
        addItem("iapapa_berry", 128);
        
        // EV-reducing berries
        addItem("pomeg_berry", 512);
        addItem("kelpsy_berry", 512);
        addItem("qualot_berry", 512);
        addItem("hondew_berry", 512);
        addItem("grepa_berry", 512);
        addItem("tamato_berry", 512);
        
        // Type-resist berries
        addItem("occa_berry", 512);
        addItem("passho_berry", 512);
        addItem("wacan_berry", 512);
        addItem("rindo_berry", 512);
        addItem("yache_berry", 512);
        addItem("chople_berry", 512);
        addItem("kebia_berry", 512);
        addItem("shuca_berry", 512);
        addItem("coba_berry", 512);
        addItem("payapa_berry", 512);
        addItem("tanga_berry", 512);
        addItem("charti_berry", 512);
        addItem("kasib_berry", 512);
        addItem("haban_berry", 512);
        addItem("colbur_berry", 512);
        addItem("babiri_berry", 512);
        addItem("roseli_berry", 512);
        addItem("chilan_berry", 512);
        
        // Pinch berries
        addItem("liechi_berry", 1024);
        addItem("ganlon_berry", 1024);
        addItem("salac_berry", 1024);
        addItem("petaya_berry", 1024);
        addItem("apicot_berry", 1024);
        addItem("lansat_berry", 2048);
        addItem("starf_berry", 2048);
        addItem("micle_berry", 1024);
        addItem("custap_berry", 1024);
        
        // Damage berries
        addItem("jaboca_berry", 512);
        addItem("rowap_berry", 512);
        addItem("enigma_berry", 1024);
        
        // New gen berries
        addItem("kee_berry", 512);
        addItem("maranga_berry", 512);
        
        // Poffin/Pokeblock berries
        addItem("cornn_berry", 128);
        addItem("magost_berry", 128);
        addItem("rabuta_berry", 128);
        addItem("nomel_berry", 128);
        addItem("spelon_berry", 128);
        addItem("pamtre_berry", 128);
        addItem("watmel_berry", 128);
        addItem("durin_berry", 128);
        addItem("belue_berry", 128);
        
        // Special berries
        addItem("drash_berry", 128);
        addItem("eggant_berry", 128);
        addItem("ginema_berry", 128);
        addItem("pumkin_berry", 128);
        addItem("touga_berry", 128);
        addItem("yago_berry", 128);
        
        // ==================== MINTS ====================
        addItem("mint_cutting", 2048);
        addItem("adamant_mint", 16384);
        addItem("bold_mint", 16384);
        addItem("brave_mint", 16384);
        addItem("calm_mint", 16384);
        addItem("careful_mint", 16384);
        addItem("gentle_mint", 16384);
        addItem("hasty_mint", 16384);
        addItem("impish_mint", 16384);
        addItem("jolly_mint", 16384);
        addItem("lax_mint", 16384);
        addItem("lonely_mint", 16384);
        addItem("mild_mint", 16384);
        addItem("modest_mint", 16384);
        addItem("naive_mint", 16384);
        addItem("naughty_mint", 16384);
        addItem("quiet_mint", 16384);
        addItem("rash_mint", 16384);
        addItem("relaxed_mint", 16384);
        addItem("sassy_mint", 16384);
        addItem("serious_mint", 16384);
        addItem("timid_mint", 16384);
        addItem("hardy_mint", 16384);
        addItem("docile_mint", 16384);
        addItem("bashful_mint", 16384);
        addItem("quirky_mint", 16384);
        
        // ==================== INCENSES ====================
        addItem("full_incense", 16384);
        addItem("lax_incense", 16384);
        addItem("luck_incense", 16384);
        addItem("odd_incense", 16384);
        addItem("pure_incense", 16384);
        addItem("rock_incense", 16384);
        addItem("rose_incense", 16384);
        addItem("sea_incense", 16384);
        addItem("wave_incense", 16384);
        addItem("incense_burner", 8192);
        
        // ==================== TYPE GEMS ====================
        addItem("bug_gem", 8192);
        addItem("dark_gem", 8192);
        addItem("dragon_gem", 8192);
        addItem("electric_gem", 8192);
        addItem("fairy_gem", 8192);
        addItem("fighting_gem", 8192);
        addItem("fire_gem", 8192);
        addItem("flying_gem", 8192);
        addItem("ghost_gem", 8192);
        addItem("grass_gem", 8192);
        addItem("ground_gem", 8192);
        addItem("ice_gem", 8192);
        addItem("normal_gem", 8192);
        addItem("poison_gem", 8192);
        addItem("psychic_gem", 8192);
        addItem("rock_gem", 8192);
        addItem("steel_gem", 8192);
        addItem("water_gem", 8192);
        
        // ==================== ARCEUS PLATES ====================
        addItem("blank_plate", 16384);
        addItem("draco_plate", 65536);
        addItem("dread_plate", 65536);
        addItem("earth_plate", 65536);
        addItem("fist_plate", 65536);
        addItem("flame_plate", 65536);
        addItem("icicle_plate", 65536);
        addItem("insect_plate", 65536);
        addItem("iron_plate", 65536);
        addItem("legend_plate", 1048576);  // 1M - Legendary
        addItem("meadow_plate", 65536);
        addItem("mind_plate", 65536);
        addItem("pixie_plate", 65536);
        addItem("sky_plate", 65536);
        addItem("splash_plate", 65536);
        addItem("spooky_plate", 65536);
        addItem("stone_plate", 65536);
        addItem("toxic_plate", 65536);
        addItem("zap_plate", 65536);
        
        // ==================== GENESECT DRIVES ====================
        addItem("burn_drive", 65536);
        addItem("chill_drive", 65536);
        addItem("douse_drive", 65536);
        addItem("shock_drive", 65536);
        
        // ==================== HELD ITEMS - BATTLE ====================
        addItem("absorb_bulb", 8192);
        addItem("adamant_orb", 131072);    // 128k
        addItem("adrenaline_orb", 8192);
        addItem("air_balloon", 8192);
        addItem("amulet_coin", 32768);
        addItem("assault_vest", 32768);
        addItem("big_root", 16384);
        addItem("binding_band", 16384);
        addItem("black_belt", 8192);
        addItem("black_glasses", 8192);
        addItem("black_sludge", 16384);
        addItem("blunder_policy", 32768);
        addItem("bright_powder", 16384);
        addItem("cell_battery", 8192);
        addItem("charcoal", 8192);
        addItem("choice_band", 32768);
        addItem("choice_scarf", 32768);
        addItem("choice_specs", 32768);
        addItem("cleanse_tag", 8192);
        addItem("damp_rock", 8192);
        addItem("destiny_knot", 16384);
        addItem("dragon_fang", 8192);
        addItem("eject_button", 16384);
        addItem("electric_seed", 8192);
        addItem("eviolite", 32768);
        addItem("exp_share", 32768);
        addItem("expert_belt", 16384);
        addItem("flame_orb", 16384);
        addItem("float_stone", 8192);
        addItem("focus_band", 16384);
        addItem("focus_sash", 32768);
        addItem("grassy_seed", 8192);
        addItem("grip_claw", 8192);
        addItem("griseous_orb", 131072);   // 128k
        addItem("hard_stone", 8192);
        addItem("heat_rock", 8192);
        addItem("heavy_duty_boots", 32768);
        addItem("icy_rock", 8192);
        addItem("iron_ball", 8192);
        addItem("lagging_tail", 8192);
        addItem("leek", 16384);
        addItem("leftovers", 32768);
        addItem("life_orb", 32768);
        addItem("light_ball", 16384);
        addItem("light_clay", 8192);
        addItem("lucky_egg", 65536);    // 64k
        addItem("lucky_punch", 16384);
        addItem("luminous_moss", 8192);
        addItem("lustrous_orb", 131072);  // 128k
        addItem("macho_brace", 16384);
        addItem("magnet", 8192);
        addItem("mental_herb", 16384);
        addItem("metal_powder", 16384);
        addItem("metronome", 16384);
        addItem("miracle_seed", 8192);
        addItem("misty_seed", 8192);
        addItem("muscle_band", 16384);
        addItem("mystic_water", 8192);
        addItem("never_melt_ice", 8192);
        addItem("poison_barb", 8192);
        addItem("power_anklet", 16384);
        addItem("power_band", 16384);
        addItem("power_belt", 16384);
        addItem("power_bracer", 16384);
        addItem("power_herb", 16384);
        addItem("power_lens", 16384);
        addItem("power_weight", 16384);
        addItem("psychic_seed", 8192);
        addItem("quick_claw", 16384);
        addItem("quick_powder", 16384);
        addItem("red_card", 16384);
        addItem("ring_target", 8192);
        addItem("rocky_helmet", 32768);
        addItem("room_service", 16384);
        addItem("safety_goggles", 32768);
        addItem("scope_lens", 16384);
        addItem("sharp_beak", 8192);
        addItem("shed_shell", 16384);
        addItem("shell_bell", 16384);
        addItem("silk_scarf", 8192);
        addItem("silver_powder", 8192);
        addItem("smoke_ball", 8192);
        addItem("smooth_rock", 8192);
        addItem("snowball", 8192);
        addItem("soft_sand", 8192);
        addItem("soothe_bell", 16384);
        addItem("soul_dew", 131072);      // 128k
        addItem("spell_tag", 8192);
        addItem("sticky_barb", 16384);
        addItem("terrain_extender", 16384);
        addItem("thick_club", 16384);
        addItem("throat_spray", 16384);
        addItem("toxic_orb", 16384);
        addItem("twisted_spoon", 8192);
        addItem("weakness_policy", 32768);
        addItem("white_herb", 16384);
        addItem("wide_lens", 16384);
        addItem("wise_glasses", 16384);
        addItem("zoom_lens", 16384);
        
        // ==================== MEGA STONES ====================
        long MEGA_STONE_EMC = 131072;  // 128k for all mega stones
        addItem("abomasite", MEGA_STONE_EMC);
        addItem("absolite", MEGA_STONE_EMC);
        addItem("aerodactylite", MEGA_STONE_EMC);
        addItem("aggronite", MEGA_STONE_EMC);
        addItem("alakazite", MEGA_STONE_EMC);
        addItem("altarianite", MEGA_STONE_EMC);
        addItem("ampharosite", MEGA_STONE_EMC);
        addItem("audinite", MEGA_STONE_EMC);
        addItem("banettite", MEGA_STONE_EMC);
        addItem("beedrillite", MEGA_STONE_EMC);
        addItem("blastoisinite", MEGA_STONE_EMC);
        addItem("blazikenite", MEGA_STONE_EMC);
        addItem("cameruptite", MEGA_STONE_EMC);
        addItem("charizardite_x", MEGA_STONE_EMC);
        addItem("charizardite_y", MEGA_STONE_EMC);
        addItem("diancite", MEGA_STONE_EMC);
        addItem("galladite", MEGA_STONE_EMC);
        addItem("garchompite", MEGA_STONE_EMC);
        addItem("gardevoirite", MEGA_STONE_EMC);
        addItem("gengarite", MEGA_STONE_EMC);
        addItem("glalitite", MEGA_STONE_EMC);
        addItem("gyaradosite", MEGA_STONE_EMC);
        addItem("heracronite", MEGA_STONE_EMC);
        addItem("houndoominite", MEGA_STONE_EMC);
        addItem("kangaskhanite", MEGA_STONE_EMC);
        addItem("latiasite", MEGA_STONE_EMC);
        addItem("latiosite", MEGA_STONE_EMC);
        addItem("lopunnite", MEGA_STONE_EMC);
        addItem("lucarionite", MEGA_STONE_EMC);
        addItem("manectite", MEGA_STONE_EMC);
        addItem("mawilite", MEGA_STONE_EMC);
        addItem("medichamite", MEGA_STONE_EMC);
        addItem("metagrossite", MEGA_STONE_EMC);
        addItem("mewtwonite_x", MEGA_STONE_EMC);
        addItem("mewtwonite_y", MEGA_STONE_EMC);
        addItem("pidgeotite", MEGA_STONE_EMC);
        addItem("pinsirite", MEGA_STONE_EMC);
        addItem("sablenite", MEGA_STONE_EMC);
        addItem("salamencite", MEGA_STONE_EMC);
        addItem("sceptilite", MEGA_STONE_EMC);
        addItem("scizorite", MEGA_STONE_EMC);
        addItem("sharpedonite", MEGA_STONE_EMC);
        addItem("slowbronite", MEGA_STONE_EMC);
        addItem("steelixite", MEGA_STONE_EMC);
        addItem("swampertite", MEGA_STONE_EMC);
        addItem("tyranitarite", MEGA_STONE_EMC);
        addItem("venusaurite", MEGA_STONE_EMC);
        
        // ==================== Z-CRYSTALS ====================
        long TYPE_Z_CRYSTAL_EMC = 65536;  // 64k for type Z-crystals
        long SPECIAL_Z_CRYSTAL_EMC = 131072;  // 128k for Pokemon-specific
        
        // Type Z-Crystals
        addItem("buginium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("darkinium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("dragonium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("electrium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("fairium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("fightinium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("firium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("flyinium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("ghostium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("grassium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("groundium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("icium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("normalium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("poisonium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("psychium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("rockium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("steelium_z", TYPE_Z_CRYSTAL_EMC);
        addItem("waterium_z", TYPE_Z_CRYSTAL_EMC);
        
        // Pokémon-specific Z-Crystals
        addItem("aloraichium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("decidium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("eevium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("incinium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("kommonium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("lunalium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("lycanium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("marshadium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("mewnium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("mimikium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("pikanium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("pikashunium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("primarium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("snorlium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("solganium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("tapunium_z", SPECIAL_Z_CRYSTAL_EMC);
        addItem("ultranecrozium_z", 262144);  // 256k - Ultra rare
        
        // ==================== VALUABLE ITEMS ====================
        addItem("tiny_mushroom", 256);
        addItem("big_mushroom", 2048);
        addItem("balm_mushroom", 32768);
        addItem("pearl", 2048);
        addItem("big_pearl", 16384);
        addItem("pearl_string", 65536);
        addItem("stardust", 2048);
        addItem("star_piece", 32768);
        addItem("comet_shard", 131072);   // 128k
        addItem("nugget", 16384);
        addItem("big_nugget", 65536);
        addItem("rare_bone", 32768);
        addItem("relic_copper", 8192);
        addItem("relic_silver", 16384);
        addItem("relic_gold", 32768);
        addItem("relic_band", 65536);
        addItem("relic_statue", 131072);
        addItem("relic_crown", 262144);   // 256k
        addItem("relic_vase", 65536);
        addItem("shoal_salt", 1024);
        addItem("shoal_shell", 1024);
        addItem("slowpoke_tail", 8192);
        addItem("strange_souvenir", 16384);
        
        // ==================== TOOLS ====================
        addItem("old_rod", 1024);
        addItem("good_rod", 4096);
        addItem("super_rod", 16384);
        addItem("wailmer_pail", 1024);
        addItem("itemfinder", 16384);
        addItem("camera", 16384);
        addItem("film", 256);
        
        // Running boots
        addItem("old_running_boots", 8192);
        addItem("new_running_boots", 16384);
        
        // Hammers (for anvil crafting)
        addItem("wood_hammer", 128);
        addItem("stone_hammer", 256);
        addItem("iron_hammer", 512);
        addItem("gold_hammer", 2048);
        addItem("diamond_hammer", 8192);
        addItem("aluminum_hammer", 2048);
        addItem("amethyst_hammer", 8192);
        addItem("crystal_hammer", 8192);
        addItem("ruby_hammer", 32768);
        addItem("sapphire_hammer", 32768);
        
        // Evolution stone hammers
        addItem("fire_stone_hammer", 32768);
        addItem("water_stone_hammer", 32768);
        addItem("thunder_stone_hammer", 32768);
        addItem("leaf_stone_hammer", 32768);
        addItem("sun_stone_hammer", 32768);
        addItem("moon_stone_hammer", 32768);
        addItem("dawn_stone_hammer", 65536);
        addItem("dusk_stone_hammer", 65536);
        
        // ==================== MACHINES ====================
        addItem("anvil", 16384);
        addItem("mechanical_anvil", 65536);
        addItem("pc", 32768);
        addItem("healer", 16384);
        addItem("fossil_cleaner", 32768);
        addItem("fossil_machine", 65536);
        addItem("cloning_machine", 262144);   // 256k
        addItem("trade_machine", 32768);
        addItem("ranch_block", 32768);
        addItem("ranch_upgrade", 16384);
        addItem("infuser", 32768);
        
        // Machine parts
        addItem("fossil_machine_base", 8192);
        addItem("fossil_machine_tank", 8192);
        addItem("fossil_machine_display", 8192);
        addItem("fossil_machine_top", 8192);
        addItem("cloner_cord", 16384);
        addItem("green_tank", 4096);
        addItem("orange_tank", 4096);
        addItem("trade_panel", 4096);
        addItem("trade_monitor", 8192);
        addItem("trade_holder_left", 4096);
        addItem("trade_holder_right", 4096);
        
        // Movement
        addItem("elevator", 8192);
        addItem("movement_plate", 2048);
        addItem("stick_plate", 2048);
        addItem("timed_fall", 2048);
        
        // Vending machines
        addItem("blue_vending_machine", 16384);
        addItem("green_vending_machine", 16384);
        addItem("orange_vending_machine", 16384);
        addItem("pink_vending_machine", 16384);
        addItem("red_vending_machine", 16384);
        addItem("yellow_vending_machine", 16384);
        
        // ==================== REPELS ====================
        addItem("repel", 512);
        addItem("super_repel", 1024);
        addItem("max_repel", 2048);
        
        // ==================== LEGENDARY ITEMS ====================
        addItem("azure_flute", 524288);      // 512k
        addItem("dna_splicers", 262144);     // 256k
        addItem("gracidea", 131072);         // 128k
        addItem("meteorite", 131072);
        addItem("prison_bottle", 262144);    // 256k
        addItem("reveal_glass", 262144);
        addItem("red_orb", 262144);
        addItem("blue_orb", 262144);
        addItem("red_chain", 524288);        // 512k
        addItem("clear_bell", 131072);
        addItem("tidal_bell", 131072);
        addItem("alpha_shard", 32768);
        addItem("omega_shard", 32768);
        addItem("orb", 16384);
        addItem("orb_of_fiery_souls", 131072);
        addItem("orb_of_frozen_souls", 131072);
        addItem("orb_of_static_souls", 131072);
        addItem("ruby_of_emotion", 131072);
        addItem("ruby_of_knowledge", 131072);
        addItem("ruby_of_willpower", 131072);
        
        // Experience items
        addItem("exp_all", 262144);   // 256k
        
        // Misc items
        addItem("isi_golden_hourglass", 262144);
        addItem("isi_silver_hourglass", 131072);
        addItem("poke_gift", 16384);
        addItem("gift_box", 8192);
        
        // Porygon pieces
        addItem("porygon", 65536);
        addItem("porygon_body", 16384);
        addItem("porygon_head", 16384);
        addItem("porygon_leg", 16384);
        addItem("porygon_tail", 16384);
        
        // ==================== TM/HM BASE VALUES ====================
        // TMs - 16k each
        for (int i = 1; i <= 174; i++) {
            addItem("tm" + i, 16384);
        }
        
        // HMs - 32k each (more valuable)
        for (int i = 1; i <= 10; i++) {
            addItem("hm" + i, 32768);
        }
        
        // ==================== ARMOR ====================
        // Aluminum armor
        addItem("aluminum_helmet", 4096);
        addItem("aluminum_chestplate", 6144);
        addItem("aluminum_leggings", 5120);
        addItem("aluminum_boots", 3072);
        
        // Evolution stone armor - 64k per piece
        String[] stoneTypes = {"fire_stone", "water_stone", "thunder_stone", "leaf_stone", 
                               "sun_stone", "moon_stone", "dawn_stone", "dusk_stone"};
        for (String stone : stoneTypes) {
            addItem(stone + "_helmet", 65536);
            addItem(stone + "_chestplate", 98304);
            addItem(stone + "_leggings", 81920);
            addItem(stone + "_boots", 49152);
        }
        
        // Team armor
        addItem("rocket_helmet", 16384);
        addItem("rocket_chestplate", 24576);
        addItem("rocket_leggings", 20480);
        addItem("rocket_boots", 12288);
        
        addItem("plasma_helmet", 16384);
        addItem("plasma_chestplate", 24576);
        addItem("plasma_leggings", 20480);
        addItem("plasma_boots", 12288);
        
        addItem("neo_plasma_helmet", 32768);
        addItem("neo_plasma_chestplate", 49152);
        addItem("neo_plasma_leggings", 40960);
        addItem("neo_plasma_boots", 24576);
        
        addItem("galactic_swag", 32768);
        addItem("galactic_chestplate", 49152);
        addItem("galactic_leggings", 40960);
        addItem("galactic_boots", 24576);
        
        addItem("aqua_helmet", 16384);
        addItem("aqua_chestplate", 24576);
        addItem("aqua_leggings", 20480);
        addItem("aqua_boots", 12288);
        
        addItem("magma_helmet", 16384);
        addItem("magma_chestplate", 24576);
        addItem("magma_leggings", 20480);
        addItem("magma_boots", 12288);
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
