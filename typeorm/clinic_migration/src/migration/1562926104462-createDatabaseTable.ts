import {MigrationInterface, QueryRunner} from "typeorm";

export class createDatabaseTable1562926104462 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "employee" ("id" int NOT NULL IDENTITY(1,1), "emplyoyeeName" nvarchar(255) NOT NULL, "isNurse" bit NOT NULL, CONSTRAINT "PK_3c2bc72f03fd5abbbc5ac169498" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "appointment" ("id" int NOT NULL IDENTITY(1,1), "queueNum" int NOT NULL, "employeeId" int NOT NULL, "checkInTime" datetime NOT NULL, "checkOutTime" datetime NOT NULL, "symptom" nvarchar(255) NOT NULL, "cancel" bit NOT NULL, "isToday" bit NOT NULL, "lastUpdBy" int NOT NULL, CONSTRAINT "PK_e8be1a53027415e709ce8a2db74" PRIMARY KEY ("id"))`);
        await queryRunner.query(`CREATE TABLE "doctor_status" ("id" int NOT NULL IDENTITY(1,1), "status" bit NOT NULL, CONSTRAINT "PK_42d978b2a99f461698b61d49007" PRIMARY KEY ("id"))`);
        await queryRunner.query(`ALTER TABLE "appointment" ADD CONSTRAINT "FK_b6e57758a28acd843878b1f30d8" FOREIGN KEY ("employeeId") REFERENCES "employee"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "appointment" DROP CONSTRAINT "FK_b6e57758a28acd843878b1f30d8"`);
        await queryRunner.query(`DROP TABLE "doctor_status"`);
        await queryRunner.query(`DROP TABLE "appointment"`);
        await queryRunner.query(`DROP TABLE "employee"`);
    }

}
