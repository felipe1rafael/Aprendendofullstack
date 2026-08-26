import { person } from "./person";

export class estudante extends person {

    constructor(name: string) {
        super(name);
    }

    public showAge(age: number): void {
        console.log("estudando");
        super.showAge(25);
    }
}