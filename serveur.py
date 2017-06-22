from flask import Flask, request
from flask_cors import CORS, cross_origin
from pprint import pprint
import random 
import json

app = Flask(__name__)
app.debug = True
CORS(app)
identifiant=[]
postSales=[]
nombre = ['toto','tata','titi']

@app.route("/rdm", methods=["GET"])
def get():
	global nombre
	temp = random.choice(nombre)
	return json.dumps(temp),200,{'Content-Type':'application/json'}

@app.route("/reset", methods=["GET"])
def get():
	global nombre
	temp = random.choice(nombre)
	return json.dumps(temp),200,{'Content-Type':'application/json'}


@app.route("/sales",methods=["POST"])
def post():
	global  postSales
	postSales = request.get_json()
	print postSales
	return json.dumps(postSales),200,{'Content-Type':'application/json'}

@app.route("/idPost",methods=["POST"])
def post():
	global  identifiant
	postSales = request.get_json()
	print postSales
	return json.dumps(postSales),200,{'Content-Type':'application/json'}


if __name__ == "__main__":
	app.run()	
