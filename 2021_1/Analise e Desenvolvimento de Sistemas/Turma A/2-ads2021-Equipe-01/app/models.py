from flask_login import UserMixin
from uuid import uuid4
from .init import db


class User(db.Model, UserMixin):
    __tablename__ = 'autenticacao'

    id = db.Column(primary_key=True, default=uuid4,)
    name = db.Column(db.String(100))
    email = db.Column(db.String(100), unique=True)
    password = db.Column(db.String(100))
    project = db.Column(db.String(255))
