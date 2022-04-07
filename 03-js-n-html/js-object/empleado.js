var empleado = {
    nombre : 'David',
    salario : 500,
    toString : function() {
        return 'Empleado ' + this.nombre 
                + ' con salario ' + this.salario
                + ' y categoría ' + this.getCategoria()
    },
    getCategoria : function() {
        throw "Undefined. must be overriden";
    }
};
console.log(empleado.nombre);

empleado.getCategoria = function() {
    return this.salario > 1000? 'Manager':'Empleado';
}


console.log(empleado.toString());
document.writeln('<p>' + empleado.toString() + '</p>');

empleado.departamento = 'DevRel';
if (!empleado.departamento) {
    console.log('Empleado no tiene departamento')
} else {
    console.log(empleado.departamento);
}

console.log(empleado.getCategoria());


