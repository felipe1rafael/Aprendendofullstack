import { DaoInterface } from "./daointerface";
import { person } from "./../classests/person";

export class personDao implements DaoInterface {
    tableName: string  = "person";

    insert(Person: person): boolean {
        return true;
    }

    update(Person: person): boolean {
        return true;
    }

    delete(id: number): boolean {
        return true;
    }

    find(id: number): person {
        return new person("mike");
    }

    findall(): [person] {
        return [new person("mike")];
    }
}
