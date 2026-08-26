"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.estudante = void 0;
const person_1 = require("./person");
class estudante extends person_1.person {
    constructor(name) {
        super(name);
    }
    showAge(age) {
        console.log("estudando");
        super.showAge(25);
    }
}
exports.estudante = estudante;
//# sourceMappingURL=estudaante.js.map