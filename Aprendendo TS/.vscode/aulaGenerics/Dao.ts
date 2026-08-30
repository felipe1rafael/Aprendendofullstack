import { DaoInterface } from "./daointer";

export class Dao<T> implements DaoInterface<T>{
    tableName: string  = "person";

    insert(Object: T): boolean {
        return true;
    }

    update(Object: T): boolean {
        return true;
    }

    delete(id: number): boolean {
        return true;
    }

    find(id: number): T {
        return null as unknown as T;
    }

    findall(): [T] {
        return [ null as unknown as T ];
    }
}
