public enum Collision {
    WALL_NORTHWEST                         (0x1),
    WALL_NORTH                             (0x2),
    WALL_NORTHEAST                         (0x4),
    WALL_EAST                              (0x8),
    WALL_SOUTHEAST                        (0x10),
    WALL_SOUTH                            (0x20),
    WALL_SOUTHWEST                        (0x40),
    WALL_WEST                             (0x80),
    OBJECT_TILE                          (0x100),

    WALL_BLOCK_NORTHWEST                 (0x200),
    WALL_BLOCK_NORTH                     (0x400),
    WALL_BLOCK_NORTHEAST                 (0x800),
    WALL_BLOCK_EAST                     (0x1000),
    WALL_BLOCK_SOUTHEAST                (0x2000),
    WALL_BLOCK_SOUTH                    (0x4000),
    WALL_BLOCK_SOUTHWEST                (0x8000),
    WALL_BLOCK_WEST                    (0x10000),

    OBJECT_BLOCK                       (0x20000),
    DECORATION_BLOCK                   (0x40000),
    MAP_BLOCK                         (0x200000),

    WALL_ALLOW_PROJECTILE_NORTHWEST   (0x400000),
    WALL_ALLOW_PROJECTILE_NORTH       (0x800000),
    WALL_ALLOW_PROJECTILE_NORTHEAST  (0x1000000),
    WALL_ALLOW_PROJECTILE_EAST       (0x2000000),
    WALL_ALLOW_PROJECTILE_SOUTHEAST  (0x4000000),
    WALL_ALLOW_PROJECTILE_SOUTH      (0x8000000),
    WALL_ALLOW_PROJECTILE_SOUTHWEST (0x10000000),
    WALL_ALLOW_PROJECTILE_WEST      (0x20000000),
    OBJECT_ALLOW_PROJECTILE         (0x40000000);

    public final int flag;

    Collision(int flag) {
        this.flag = flag;
    }
}
