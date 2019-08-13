import {MigrationInterface, QueryRunner} from "typeorm";

export class EmployeeTableWithPassword1565284842661 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "employee" ADD "email" nvarchar(255) NOT NULL`);
        await queryRunner.query(`ALTER TABLE "employee" ADD "password" nvarchar(255) NOT NULL`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "employee" DROP COLUMN "password"`);
        await queryRunner.query(`ALTER TABLE "employee" DROP COLUMN "email"`);
    }

}
