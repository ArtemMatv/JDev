select *
from Users, (SELECT userId
			from users_roles, 
				(select id
				from roles
				where title = "Guest") roles
			where roleId = roles.id) users
where id = users.userId;
