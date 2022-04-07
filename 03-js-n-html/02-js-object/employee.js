var empleado = {
    nombre : 'David',
    salario : 700,
    toString : function() {
        return 'N:' + this.nombre
             + ', S:' + this.salario; 
    }
}

console.log(empleado.toString());

document.writeln('Empleado creado' + empleado.toString());

empleado.getCategoria = function() {
    return this.salario > 800 ? 'Superior':'Normal';
}

console.log('C:' + empleado.getCategoria());
document.writeln(' Empleado tiene categoria ' + empleado.getCategoria());
