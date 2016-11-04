<div>
<h2>Student Details</h2>
<table id="studDetails">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Id</th>
					<th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="stud in ctrl.students">
					<td>{{stud.name}}</td>
					<td>{{stud.age}}</td>
					<td>{{stud.id}}</td>
					<td><button  ng-click="ctrl.remove(stud)">Remove</button>&nbsp;&nbsp;<button  ng-click="ctrl.edit(stud.id)">Modify</button></td>
				</tr>
			</tbody>
		</table>
</div>