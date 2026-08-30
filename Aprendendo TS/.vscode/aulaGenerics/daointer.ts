export interface DaoInterface <T>{
    tableName: string;

    insert(Object: T): boolean;

    update(Object: T): boolean;

    delete(id: number): boolean;

    find(id: number): T;

    findall(): [T];
}