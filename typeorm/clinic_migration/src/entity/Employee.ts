import {Entity, PrimaryGeneratedColumn, Column, OneToMany} from "typeorm";
import { Appointment } from "./Appointment";

@Entity()
export class Employee {

    @PrimaryGeneratedColumn()
    id: number;

    @Column()
    badgeNumber: number;

    @Column()
    employeeName: String;

    @Column()
    isNurse: boolean;

    @OneToMany(type => Appointment, appointment=> appointment.employee)
    appointment: Appointment[]


}
