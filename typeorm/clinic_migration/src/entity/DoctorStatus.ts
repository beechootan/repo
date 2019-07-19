import {Entity, PrimaryGeneratedColumn, Column} from "typeorm";

@Entity()
export class DoctorStatus {

    @PrimaryGeneratedColumn()
    id: number;


    @Column()
    status: boolean;


}
