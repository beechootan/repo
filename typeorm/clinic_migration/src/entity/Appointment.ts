import {Entity, PrimaryGeneratedColumn, Column, ManyToOne, JoinColumn} from "typeorm";
import { Employee } from "./Employee";

@Entity()
export class Appointment {

    @PrimaryGeneratedColumn()
    id: String;


    @Column()
    queueNum: number;

    @Column()
    employeeId: number;

    @Column({nullable : true, type: 'datetime'})
    checkInTime: Date;

    @Column({nullable : true, type: 'datetime'})
    checkOutTime: Date;

    @Column({nullable : true})
    symptom: String;

    @Column()
    cancel: boolean;

    @Column()
    isToday: boolean;

    @Column()
    lastUpdBy: number;



    @ManyToOne(type => Employee, employee => employee.appointment)
    @JoinColumn({name: "employeeId"})
    employee: Employee



}

