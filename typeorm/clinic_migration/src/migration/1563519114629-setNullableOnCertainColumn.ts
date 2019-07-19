import {MigrationInterface, QueryRunner} from "typeorm";

export class setNullableOnCertainColumn1563519114629 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "checkInTime" datetime`);
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "checkOutTime" datetime`);
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "symptom" nvarchar(255)`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "symptom" nvarchar(255) NOT NULL`);
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "checkOutTime" datetime NOT NULL`);
        await queryRunner.query(`ALTER TABLE "appointment" ALTER COLUMN "checkInTime" datetime NOT NULL`);
    }

}
