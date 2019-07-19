import {MigrationInterface, QueryRunner} from "typeorm";

export class UpdateTableColumnName1563529749915 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`EXEC sp_rename "employee.employeeId", "badgeNumber"`);
        await queryRunner.query(`EXEC sp_rename "appointment.cancel", "status"`);
        await queryRunner.query(`ALTER TABLE "appointment" DROP COLUMN "status"`);
        await queryRunner.query(`ALTER TABLE "appointment" ADD "status" nvarchar(255) NOT NULL CONSTRAINT "DF_493b116fd1ca369b57ea9675ef7" DEFAULT 'Open'`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "appointment" DROP CONSTRAINT "DF_493b116fd1ca369b57ea9675ef7"`);
        await queryRunner.query(`ALTER TABLE "appointment" DROP COLUMN "status"`);
        await queryRunner.query(`ALTER TABLE "appointment" ADD "status" bit NOT NULL`);
        await queryRunner.query(`EXEC sp_rename "appointment.status", "cancel"`);
        await queryRunner.query(`EXEC sp_rename "employee.badgeNumber", "employeeId"`);
    }

}
