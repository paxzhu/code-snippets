import argparse
import getpass
parser = argparse.ArgumentParser(prog='create_user', description='Create a new user.')
parser.add_argument('-u', '--username', required=True)
args = parser.parse_args()

password = getpass.getpass(prompt=f"Enter password for {args.username}: ")
confirm_password = getpass.getpass(prompt=f"Confirm password for {args.username}: ")
parser.add_argument('-p', '--password', required=True)
if password != confirm_password:
    print(f"ERROR: Access denied for user {args.username}, wrong password")

