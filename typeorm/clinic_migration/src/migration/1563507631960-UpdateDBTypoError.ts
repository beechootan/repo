import {MigrationInterface, QueryRunner} from "typeorm";

export class UpdateDBTypoError1563507631960 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "employee" DROP COLUMN "emplyoyeeName"`);
        await queryRunner.query(`ALTER TABLE "employee" ADD "employeeId" int NOT NULL`);
        await queryRunner.query(`ALTER TABLE "employee" ADD "employeeName" nvarchar(255) NOT NULL`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "employee" DROP COLUMN "employeeName"`);
        await queryRunner.query(`ALTER TABLE "employee" DROP COLUMN "employeeId"`);
        await queryRunner.query(`ALTER TABLE "employee" ADD "emplyoyeeName" nvarchar(255) NOT NULL`);
    }

}
