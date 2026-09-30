import functools

class Relation:
    def __init__(self, name, attributes, data):
        self.name = name
        self.attributes = attributes
        self.data = data

    def select(self, condition_func):
        filtered_data = [row for row in self.data if condition_func(row)]
        return Relation(f"sigma({self.name})", self.attributes, filtered_data)

    def project(self, columns):
        new_data = []
        seen = set()
        for row in self.data:
            new_row = tuple(row[col] for col in columns)
            if new_row not in seen:
                new_data.append(dict(zip(columns, new_row)))
                seen.add(new_row)
        return Relation(f"pi({self.name})", columns, new_data)

    def natural_join(self, other_relation):
        common_attrs = list(set(self.attributes) & set(other_relation.attributes))
        if not common_attrs:
            return self.cartesian_product(other_relation)
        
        joined_data = []
        for r1 in self.data:
            for r2 in other_relation.data:
                match = all(r1[attr] == r2[attr] for attr in common_attrs)
                if match:
                    new_row = {**r1, **r2}
                    joined_data.append(new_row)
        
        new_attrs = list(joined_data[0].keys()) if joined_data else self.attributes + other_relation.attributes
        return Relation(f"({self.name} ⋈ {other_relation.name})", new_attrs, joined_data)

    def __repr__(self):
        if not self.data:
            return f"Relacion: {self.name} (Vacia)"
        
        headers = list(self.data[0].keys())
        lines = [f"--- RELACION: {self.name} ---", " | ".join(headers)]
        for row in self.data:
            lines.append(" | ".join(str(row[h]) for h in headers))
        return "\n".join(lines) + "\n"

class Graph:
    def __init__(self):
        self.adjacency_list = {}

    def add_edge(self, u, v):
        if u not in self.adjacency_list: self.adjacency_list[u] = []
        if v not in self.adjacency_list: self.adjacency_list[v] = []
        self.adjacency_list[u].append(v)

    def topological_sort(self):
        visited = set()
        stack = []
        
        def dfs(node):
            visited.add(node)
            for neighbor in self.adjacency_list.get(node, []):
                if neighbor not in visited:
                    dfs(neighbor)
            stack.insert(0, node)

        nodes = list(self.adjacency_list.keys())
        for node in nodes:
            if node not in visited:
                dfs(node)
        return stack

def main():
    estudiantes_data = [
        {"id": "E001", "nombre": "Erick Rodriguez", "carrera": "Computacion"},
        {"id": "E002", "nombre": "Mario Jijon", "carrera": "Telematica"},
        {"id": "E003", "nombre": "Kevin Morales", "carrera": "Computacion"}
    ]
    
    materias_data = [
        {"cod": "MAT101", "materia": "Mat. Discretas", "creditos": 4},
        {"cod": "CMP202", "materia": "Est. Datos", "creditos": 3},
        {"cod": "CMP305", "materia": "Base de Datos", "creditos": 3},
        {"cod": "CMP100", "materia": "Fund. Programacion", "creditos": 3}
    ]

    inscripciones_data = [
        {"id": "E001", "cod": "MAT101", "semestre": "2024-I"},
        {"id": "E001", "cod": "CMP305", "semestre": "2025-II"},
        {"id": "E003", "cod": "CMP100", "semestre": "2024-I"}
    ]

    R_Estudiantes = Relation("Estudiantes", ["id", "nombre", "carrera"], estudiantes_data)
    R_Materias = Relation("Materias", ["cod", "materia", "creditos"], materias_data)
    R_Inscripciones = Relation("Inscripciones", ["id", "cod", "semestre"], inscripciones_data)

    print("\n[1] CONSULTA DE ALGEBRA RELACIONAL COMPLEJA")
    resultado = R_Estudiantes.select(lambda x: x["carrera"] == "Computacion") \
                             .natural_join(R_Inscripciones) \
                             .natural_join(R_Materias) \
                             .project(["nombre", "materia", "semestre"])
    print(resultado)

    print("[2] GRAFO DE PRERREQUISITOS (Malla Curricular)")
    malla = Graph()
    malla.add_edge("Fund. Programacion", "Est. Datos")
    malla.add_edge("Est. Datos", "Base de Datos")
    malla.add_edge("Mat. Discretas", "Base de Datos")
    
    study_plan = malla.topological_sort()
    print(f"Orden Topologico Sugerido: {' -> '.join(study_plan)}")

if __name__ == "__main__":
    main()